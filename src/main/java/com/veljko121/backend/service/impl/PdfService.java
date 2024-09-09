package com.veljko121.backend.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.model.*;
import com.veljko121.backend.service.IExhibitionProposalService;
import com.veljko121.backend.service.IExhibitionService;
import com.veljko121.backend.service.IRoomService;
import com.veljko121.backend.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.stream.Collectors;


import com.veljko121.backend.service.IPdfService;

import static com.veljko121.backend.core.enums.ExhibitionTheme.getDisplayName;

@Service
public class PdfService implements IPdfService {
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private IExhibitionService exhibitionService;

    @Autowired
    private IExhibitionProposalService exhibitionProposalService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private UserService userService;



    public ByteArrayInputStream generateOrganizerExhibitionReport(Integer organizerId) throws DocumentException, IOException {
        List<Exhibition> exhibitions = exhibitionService.findByOrganizerId(organizerId);
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        addContentToOrganizerExhibitionDocument(document, organizerId, exhibitions);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream generateCuratorExhibitionReport(Integer curatorId) throws DocumentException, IOException {
        List<Exhibition> exhibitions = exhibitionService.findByCuratorId(curatorId);
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        addContentToCuratorExhibitionDocument(document, curatorId, exhibitions);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    private PdfPCell createPaddedCell(String text, Font font, boolean isHeader) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(8);  // Add consistent padding
        if (isHeader) {
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);  // Highlight header cells
        }
        return cell;
    }


    private void addContentToOrganizerExhibitionDocument(Document document, Integer organizerId, List<Exhibition> exhibitions) throws DocumentException, IOException {
        // Load logo image
        Image logo = Image.getInstance("src/main/resources/images/color-logo1.png");  // Use the path where the logo is stored
        logo.scaleToFit(250, 100);  // Adjust size as needed
        logo.setAlignment(Element.ALIGN_CENTER);  // Align logo in the center (change to ALIGN_LEFT for left alignment)
        document.add(logo);

        // Add some spacing after the logo
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));  // Extra spacing for breathing room


        Font headingFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph heading = new Paragraph("Organizer's Exhibition Report", headingFont);
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);
        document.add(new Paragraph(" "));

        Font metaFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        User user = userService.findById(organizerId);

        // General Overview Section
        List<ExhibitionProposal> proposals = exhibitionProposalService.findByOrganizerId(organizerId);
        addGeneralOverviewSection(document, exhibitions, proposals);


        // Financial Summary Section
        addFinancialSummarySection(document, exhibitions);

        // Engagement Overview Section
        addEngagementOverviewSection(document, exhibitions);

        // Center "Generated on" and "Requested by" in a table
        PdfPTable metaInfoTable = new PdfPTable(1);  // Single column table
        metaInfoTable.setWidthPercentage(80);  // Set table width to 80% of the page
        metaInfoTable.setHorizontalAlignment(Element.ALIGN_CENTER);  // Align center

        PdfPCell generatedCell = new PdfPCell(new Phrase("Generated on: " + DateUtil.dateToString(LocalDate.now()), metaFont));
        generatedCell.setBorder(Rectangle.NO_BORDER);  // Remove borders for aesthetics
        metaInfoTable.addCell(generatedCell);

        PdfPCell requestedCell = new PdfPCell(new Phrase("Requested by: " + user.getFirstName() + ' ' + user.getLastName()));
        requestedCell.setBorder(Rectangle.NO_BORDER);
        metaInfoTable.addCell(requestedCell);

        document.add(metaInfoTable);
        document.add(new Paragraph(" "));  // Add space after the table

        // Add footer section at the bottom
        document.add(new LineSeparator(1, 100, BaseColor.BLACK, Element.ALIGN_CENTER, -2));

        // Footer content
        Paragraph footer = new Paragraph("Artium Historia Museum | Address: 123 Museum St, City | Website: www.artiumhistoria.com | Contact: info@artiumhistoria.com", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC));
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);


    }

    private void addGeneralOverviewSection(Document document, List<Exhibition> exhibitions, List<ExhibitionProposal> proposals) throws DocumentException {
        Font sectionHeadingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph generalOverviewHeading = new Paragraph("General Overview", sectionHeadingFont);
        generalOverviewHeading.setAlignment(Element.ALIGN_CENTER);
        document.add(generalOverviewHeading);
        document.add(new Paragraph(" "));

        // General overview table with bold metrics
        PdfPTable table = new PdfPTable(2);  // 2 columns
        table.setWidthPercentage(80);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        // Add headers
        table.addCell(createPaddedCell("Metric", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), true));
        table.addCell(createPaddedCell("Value", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), true));

        long totalProposals = proposals.size() + exhibitions.size();
        long realizedExhibitions = exhibitions.size();
        double realizationPercentage = (realizedExhibitions * 100.0) / totalProposals;
        long openedExhibitions = exhibitions.stream().filter(e -> e.getStatus() == ExhibitionStatus.OPENED).count();
        long readyToOpenExhibitions = exhibitions.stream().filter(e -> e.getStatus() == ExhibitionStatus.READY_TO_OPEN).count();
        long closedExhibitions = exhibitions.stream().filter(e -> e.getStatus() == ExhibitionStatus.CLOSED).count();
        long reservedRooms = exhibitions.stream().filter(e -> e.getStatus() == ExhibitionStatus.OPENED || e.getStatus() == ExhibitionStatus.READY_TO_OPEN)
                .mapToLong(e -> e.getExhibitionProposal().getRoomReservation() != null ? 1 : 0).sum();
        long availableRooms = roomService.countRoomsNotReservedForOpenExhibitions();

        // Add rows
        table.addCell(createPaddedCell("Total exhibitions proposed", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(totalProposals), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("Exhibitions realized", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(realizedExhibitions) + " (" + String.format("%.2f", realizationPercentage) + "%)", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("Current exhibitions", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(openedExhibitions), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("Upcoming exhibitions", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(readyToOpenExhibitions), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("Past exhibitions", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(closedExhibitions), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("Rooms reserved", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(reservedRooms), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("Rooms available for planning", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(availableRooms), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));  // Add spacing
        document.add(table);
    }

    private void addFinancialSummarySection(Document document, List<Exhibition> exhibitions) throws DocumentException {
        Font sectionHeadingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph financialSummaryHeading = new Paragraph("Financial Summary", sectionHeadingFont);
        financialSummaryHeading.setAlignment(Element.ALIGN_CENTER);  // Center the heading
        document.add(financialSummaryHeading);
        document.add(new Paragraph(" "));  // Add spacing

        BigDecimal totalRevenue = exhibitions.stream()
                .map(Exhibition::getRevenue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalAdultTicketPrice = exhibitions.stream()
                .map(e -> e.getExhibitionProposal().getExhibitionPriceList().getAdultTicketPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalMinorTicketPrice = exhibitions.stream()
                .map(e -> e.getExhibitionProposal().getExhibitionPriceList().getMinorTicketPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        long totalSoldTickets = exhibitions.stream()
                .mapToLong(e -> e.getTickets().size())
                .sum();

        long totalVisitors = exhibitions.stream()
                .mapToLong(e -> e.getTickets().stream().mapToLong(t -> t.getNumberOfAdults() + t.getNumberOfMinors()).sum())
                .sum();

        BigDecimal averageAdultTicketPrice = totalAdultTicketPrice.divide(new BigDecimal(exhibitions.size()), 2, RoundingMode.HALF_UP);
        BigDecimal averageMinorTicketPrice = totalMinorTicketPrice.divide(new BigDecimal(exhibitions.size()), 2, RoundingMode.HALF_UP);

        // Create a table for the financial summary
        PdfPTable financialTable = new PdfPTable(2);  // 2 columns
        financialTable.setWidthPercentage(80);  // Set table width to 80% of the page
        financialTable.setSpacingBefore(10f);
        financialTable.setSpacingAfter(10f);
        financialTable.setHorizontalAlignment(Element.ALIGN_CENTER);  // Align the table to the center

        // Add headers
        financialTable.addCell(createPaddedCell("Metric", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), true));
        financialTable.addCell(createPaddedCell("Value", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), true));

        // Add data rows
        financialTable.addCell(createPaddedCell("Total revenue", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        financialTable.addCell(createPaddedCell("$" + totalRevenue, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        financialTable.addCell(createPaddedCell("Average adult ticket price", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        financialTable.addCell(createPaddedCell("$" + averageAdultTicketPrice, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        financialTable.addCell(createPaddedCell("Average minor ticket price", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        financialTable.addCell(createPaddedCell("$" + averageMinorTicketPrice, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        financialTable.addCell(createPaddedCell("Total tickets sold", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        financialTable.addCell(createPaddedCell(String.valueOf(totalSoldTickets), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        financialTable.addCell(createPaddedCell("Total visitors", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        financialTable.addCell(createPaddedCell(String.valueOf(totalVisitors), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        // Add the table to the document
        document.add(new Paragraph(" "));  // Add some spacing before the table
        document.add(new Paragraph(" "));  // Add spacing
        document.add(financialTable);
    }


    private void addEngagementOverviewSection(Document document, List<Exhibition> exhibitions) throws DocumentException {
        Font sectionHeadingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph engagementOverviewHeading = new Paragraph("Engagement Overview", sectionHeadingFont);
        engagementOverviewHeading.setAlignment(Element.ALIGN_CENTER);  // Center the heading
        document.add(engagementOverviewHeading);
        document.add(new Paragraph(" "));  // Add spacing

        long totalReviews = exhibitions.stream().mapToLong(e -> e.getReviews().size()).sum();
        double averageRating = exhibitions.stream()
                .mapToDouble(Exhibition::getAverageRating)
                .average()
                .orElse(0.0);
        long totalComments = exhibitions.stream().mapToLong(e -> e.getComments().size()).sum();

        // Create a table for the engagement overview
        PdfPTable engagementTable = new PdfPTable(2);  // 2 columns
        engagementTable.setWidthPercentage(80);  // Set table width to 80% of the page
        engagementTable.setSpacingBefore(10f);
        engagementTable.setSpacingAfter(10f);
        engagementTable.setHorizontalAlignment(Element.ALIGN_CENTER);  // Align the table to the center

        // Add headers
        engagementTable.addCell(createPaddedCell("Metric", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), true));
        engagementTable.addCell(createPaddedCell("Value", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), true));

        // Add data rows
        engagementTable.addCell(createPaddedCell("Total reviews", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        engagementTable.addCell(createPaddedCell(String.valueOf(totalReviews), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        engagementTable.addCell(createPaddedCell("Average exhibition rating", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        engagementTable.addCell(createPaddedCell(String.format("%.2f", averageRating), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        engagementTable.addCell(createPaddedCell("Total comments", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        engagementTable.addCell(createPaddedCell(String.valueOf(totalComments), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        // Add the table to the document
        document.add(new Paragraph(" "));  // Add some spacing before the table
        document.add(engagementTable);
    }

    private void addContentToCuratorExhibitionDocument(Document document, Integer curatorId, List<Exhibition> exhibitions) throws DocumentException, IOException {
        // Load logo image
        Image logo = Image.getInstance("src/main/resources/images/color-logo1.png");  // Adjust path accordingly
        logo.scaleToFit(250, 100);  // Adjust size as needed
        logo.setAlignment(Element.ALIGN_CENTER);
        document.add(logo);

        // Add some spacing after the logo
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        // Add the heading
        Font headingFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph heading = new Paragraph("Curator's Exhibition Report", headingFont);
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);
        document.add(new Paragraph(" "));

        // General Overview Section
        addGeneralOverviewSectionForCurator(document, exhibitions, curatorId);

        // Visitor Feedback Summary Section
        addVisitorFeedbackSummarySection(document, exhibitions);


        // Insights Section
        addInsightsSection(document, exhibitions);

        // Meta info (Generated on, Requested by)
        Font metaFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        User user = userService.findById(curatorId);

        PdfPTable metaInfoTable = new PdfPTable(1);  // Single column table
        metaInfoTable.setWidthPercentage(80);  // Set table width to 80% of the page
        metaInfoTable.setHorizontalAlignment(Element.ALIGN_CENTER);  // Align center

        PdfPCell generatedCell = new PdfPCell(new Phrase("Generated on: " + DateUtil.dateToString(LocalDate.now()), metaFont));
        generatedCell.setBorder(Rectangle.NO_BORDER);  // Remove borders for aesthetics
        metaInfoTable.addCell(generatedCell);

        PdfPCell requestedCell = new PdfPCell(new Phrase("Requested by: " + user.getFirstName() + ' ' + user.getLastName()));
        requestedCell.setBorder(Rectangle.NO_BORDER);
        metaInfoTable.addCell(requestedCell);

        document.add(metaInfoTable);
        document.add(new Paragraph(" "));  // Add space after the table

        // Footer
        addFooter(document);
    }
    private void addGeneralOverviewSectionForCurator(Document document, List<Exhibition> exhibitions, Integer curatorId) throws DocumentException {
        Font sectionHeadingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph generalOverviewHeading = new Paragraph("General Overview", sectionHeadingFont);
        generalOverviewHeading.setAlignment(Element.ALIGN_CENTER);
        document.add(generalOverviewHeading);
        document.add(new Paragraph(" "));

        // General overview table with bold metrics
        PdfPTable table = new PdfPTable(2);  // 2 columns
        table.setWidthPercentage(80);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        // Add headers
        table.addCell(createPaddedCell("Metric", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), true));
        table.addCell(createPaddedCell("Value", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), true));

        long totalExhibitionsCurated = exhibitions.size();
        long totalItemsDisplayed = exhibitions.stream()
                .mapToLong(exhibition -> exhibition.getItemReservations().size()).sum();
        long openedExhibitions = exhibitions.stream()
                .filter(e -> e.getStatus() == ExhibitionStatus.OPENED).count();
        long readyToOpenExhibitions = exhibitions.stream()
                .filter(e -> e.getStatus() == ExhibitionStatus.READY_TO_OPEN).count();
        long closedExhibitions = exhibitions.stream()
                .filter(e -> e.getStatus() == ExhibitionStatus.CLOSED).count();

        // Add rows
        table.addCell(createPaddedCell("Total exhibitions curated", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(totalExhibitionsCurated), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("Total items displayed", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(totalItemsDisplayed), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("OPENED exhibitions", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(openedExhibitions), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("READY TO OPEN exhibitions", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(readyToOpenExhibitions), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        table.addCell(createPaddedCell("CLOSED exhibitions", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        table.addCell(createPaddedCell(String.valueOf(closedExhibitions), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        document.add(new Paragraph(" "));
        document.add(table);
    }

    private void addVisitorFeedbackSummarySection(Document document, List<Exhibition> exhibitions) throws DocumentException {
        Font sectionHeadingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph feedbackSummaryHeading = new Paragraph("Visitor Feedback Summary", sectionHeadingFont);
        feedbackSummaryHeading.setAlignment(Element.ALIGN_CENTER);
        document.add(feedbackSummaryHeading);
        document.add(new Paragraph(" "));

        // Feedback summary table
        PdfPTable feedbackTable = new PdfPTable(2);  // 2 columns
        feedbackTable.setWidthPercentage(80);
        feedbackTable.setSpacingBefore(10f);
        feedbackTable.setSpacingAfter(10f);
        feedbackTable.setHorizontalAlignment(Element.ALIGN_CENTER);

        // Add headers
        feedbackTable.addCell(createPaddedCell("Metric", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), true));
        feedbackTable.addCell(createPaddedCell("Value", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), true));

        long totalReviews = exhibitions.stream().mapToLong(e -> e.getReviews().size()).sum();
        double averageRating = exhibitions.stream()
                .filter(exhibition -> exhibition.getAverageRating() > 0.0)  // Exclude exhibitions with no reviews (avg rating 0.0)
                .mapToDouble(Exhibition::getAverageRating)
                .average()
                .orElse(0.0);  // If no exhibitions have ratings, return 0.0

        long totalComments = exhibitions.stream().mapToLong(e -> e.getComments().size()).sum();

        long fiveStarRatings = exhibitions.stream().mapToLong(e -> e.getReviews().stream().filter(r -> r.getRating() == 5).count()).sum();
        long fourStarRatings = exhibitions.stream().mapToLong(e -> e.getReviews().stream().filter(r -> r.getRating() == 4).count()).sum();
        long threeStarRatings = exhibitions.stream().mapToLong(e -> e.getReviews().stream().filter(r -> r.getRating() == 3).count()).sum();
        long twoStarRatings = exhibitions.stream().mapToLong(e -> e.getReviews().stream().filter(r -> r.getRating() == 2).count()).sum();
        long oneStarRatings = exhibitions.stream().mapToLong(e -> e.getReviews().stream().filter(r -> r.getRating() == 1).count()).sum();

        feedbackTable.addCell(createPaddedCell("Total reviews", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        feedbackTable.addCell(createPaddedCell(String.valueOf(totalReviews), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        feedbackTable.addCell(createPaddedCell("Average rating", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        feedbackTable.addCell(createPaddedCell(String.format("%.2f", averageRating), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        feedbackTable.addCell(createPaddedCell("5-star ratings", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        feedbackTable.addCell(createPaddedCell(String.valueOf(fiveStarRatings), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        feedbackTable.addCell(createPaddedCell("4-star ratings", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        feedbackTable.addCell(createPaddedCell(String.valueOf(fourStarRatings), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        feedbackTable.addCell(createPaddedCell("3-star ratings", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        feedbackTable.addCell(createPaddedCell(String.valueOf(threeStarRatings), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        feedbackTable.addCell(createPaddedCell("2-star ratings", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        feedbackTable.addCell(createPaddedCell(String.valueOf(twoStarRatings), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        feedbackTable.addCell(createPaddedCell("1-star ratings", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        feedbackTable.addCell(createPaddedCell(String.valueOf(oneStarRatings), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        feedbackTable.addCell(createPaddedCell("Total comments", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        feedbackTable.addCell(createPaddedCell(String.valueOf(totalComments), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        document.add(new Paragraph(" "));
        document.add(feedbackTable);
    }

    private void addInsightsSection(Document document, List<Exhibition> exhibitions) throws DocumentException {
        Font sectionHeadingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph insightsHeading = new Paragraph("Insights", sectionHeadingFont);
        insightsHeading.setAlignment(Element.ALIGN_CENTER);
        document.add(insightsHeading);
        document.add(new Paragraph(" "));

        // Insights table
        PdfPTable insightsTable = new PdfPTable(2);  // 2 columns
        insightsTable.setWidthPercentage(80);
        insightsTable.setSpacingBefore(10f);
        insightsTable.setSpacingAfter(10f);
        insightsTable.setHorizontalAlignment(Element.ALIGN_CENTER);

        // Add headers
        insightsTable.addCell(createPaddedCell("Insight", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), true));
        insightsTable.addCell(createPaddedCell("Value", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), true));

        Map<String, Long> themeCounts = exhibitions.stream().collect(Collectors.groupingBy(e -> getDisplayName(e.getTheme()), Collectors.counting()));
        String mostPopularTheme = themeCounts.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("N/A");

        Exhibition highestAttendanceExhibition = exhibitions.stream().max(Comparator.comparing(Exhibition::getTotalVisitors)).orElse(null);
        Exhibition lowestAttendanceExhibition = exhibitions.stream().min(Comparator.comparing(Exhibition::getTotalVisitors)).orElse(null);

        Exhibition highestRatingExhibition = exhibitions.stream().max(Comparator.comparing(Exhibition::getAverageRating)).orElse(null);
        Exhibition lowestRatingExhibition = exhibitions.stream().min(Comparator.comparing(Exhibition::getAverageRating)).orElse(null);

        insightsTable.addCell(createPaddedCell("Most curated theme", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        insightsTable.addCell(createPaddedCell(mostPopularTheme, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        insightsTable.addCell(createPaddedCell("Exhibition with highest attendance", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        insightsTable.addCell(createPaddedCell(highestAttendanceExhibition != null ? highestAttendanceExhibition.getName() + "\n(Theme: " + getDisplayName(highestAttendanceExhibition.getTheme()) + ")" : "N/A", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        insightsTable.addCell(createPaddedCell("Exhibition with lowest attendance", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        insightsTable.addCell(createPaddedCell(lowestAttendanceExhibition != null ? lowestAttendanceExhibition.getName() + "\n(Theme: " + getDisplayName(lowestAttendanceExhibition.getTheme()) + ")" : "N/A", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        insightsTable.addCell(createPaddedCell("Exhibition with highest average rating", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        insightsTable.addCell(createPaddedCell(highestRatingExhibition != null ? highestRatingExhibition.getName() + "\n(Theme: " + getDisplayName(highestRatingExhibition.getTheme()) + ")" : "N/A", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        insightsTable.addCell(createPaddedCell("Exhibition with lowest average rating", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD), false));
        insightsTable.addCell(createPaddedCell(lowestRatingExhibition != null ? lowestRatingExhibition.getName() + "\n(Theme: " + getDisplayName(lowestRatingExhibition.getTheme()) + ")" : "N/A", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL), false));

        document.add(new Paragraph(" "));
        document.add(insightsTable);
    }


    private void addFooter(Document document) throws DocumentException {
        document.add(new LineSeparator(1, 100, BaseColor.BLACK, Element.ALIGN_CENTER, -2));

        Paragraph footer = new Paragraph("Artium Historia Museum | Address: 123 Museum St, City | Website: www.artiumhistoria.com | Contact: info@artiumhistoria.com",
                new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC));
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);
    }



}
