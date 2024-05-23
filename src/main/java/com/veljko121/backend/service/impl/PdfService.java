package com.veljko121.backend.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.veljko121.backend.model.tours.PersonalTourRequest;
import com.veljko121.backend.service.impl.tours.PersonalTourRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;



import com.veljko121.backend.model.Item;
import com.veljko121.backend.model.User;
import com.veljko121.backend.service.IPdfService;

@Service
public class PdfService implements IPdfService {
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private PersonalTourRequestService requestService;

    @Autowired
    private UserService userService;

    @Override
    public ByteArrayInputStream generateCleansedItemsPdf(Integer requestedBy) throws DocumentException, IOException {
        List<Item> cleansedItems = itemService.getCleansedItemsForPreviousMonth();
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        
        document.open();
        addContentToDocument(document, requestedBy, cleansedItems);
        document.close();
        
        return new ByteArrayInputStream(out.toByteArray());
    }

    @Override
    public ByteArrayInputStream generateCleansedItemsPdfForPersonal(Integer requestedBy) throws DocumentException, IOException {
        List<Item> cleansedItems = itemService.getCleansedItemsForRestaurateur(requestedBy);
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        
        document.open();
        addContentToDocumentPersonal(document, requestedBy, cleansedItems);
        document.close();
        
        return new ByteArrayInputStream(out.toByteArray());
    }

    @Override
    public ByteArrayInputStream generateRequestsPdf(Integer organizerId) throws DocumentException, IOException {
        List<PersonalTourRequest> requests = requestService.findByOrganizerId(organizerId);
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        addContentToRequestsDocument(document, organizerId, requests, false);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    @Override
    public ByteArrayInputStream generateHandledRequestsPdf(Integer organizerId) throws DocumentException, IOException {
        List<PersonalTourRequest> requests = requestService.findRequestsForPreviousMonth();
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        addContentToRequestsDocument(document, organizerId, requests, true);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    @Override
    public void saveCleansedItemsPdf(Integer requestedBy) throws DocumentException, IOException {
        String timestamp = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now());
        String desktopPath = System.getProperty("user.home") + "/Desktop/cleansed_items_report_" + timestamp + ".pdf";
        List<Item> cleansedItems = itemService.getCleansedItemsForPreviousMonth();
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(desktopPath));
        
        document.open();
        addContentToDocument(document, requestedBy, cleansedItems);
        document.close();
    }

    @Override
    public void saveRequestsPdf(Integer organizerId) throws DocumentException, IOException {
        String timestamp = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now());
        String desktopPath = System.getProperty("user.home") + "/Desktop/personal_tour_requests_report" + timestamp + ".pdf";
        List<PersonalTourRequest> requests = requestService.findRequestsForPreviousMonth();
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(desktopPath));

        document.open();
        addContentToRequestsDocument(document, organizerId, requests, false);
        document.close();
    }

    private void addContentToDocument(Document document, Integer requestedBy, List<Item> cleansedItems) throws DocumentException {
        // Add heading
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph heading = new Paragraph("Cleansed Items Report", font);
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);
        
        document.add(new Paragraph(" "));
        
        // Add meta information
        Font metaFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        YearMonth previousMonth = YearMonth.now().minusMonths(1);
        
        User user = userService.findById(requestedBy);

        document.add(new Paragraph("Generated on: " + LocalDate.now().format(DateTimeFormatter.ISO_DATE), metaFont));
        document.add(new Paragraph("Requested by: " + user.getFirstName() + ' ' + user.getLastName(), metaFont));
        document.add(new Paragraph("For the month: " + previousMonth.format(formatter), metaFont));
        
        document.add(new Paragraph(" "));
        
        // Create table
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{3, 2, 2, 2});
        
        Font tableHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        
        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Item", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Cleaning started", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Cleaning ended", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Cleaned By", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        Font tableFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        
        for (Item item : cleansedItems) {
            PdfPCell cell;
            
            cell = new PdfPCell(new Phrase(item.getName(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(item.getCleaning().getPutToCleaningTime().toString(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(item.getCleaning().getFinishCleaningTime().toString(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(item.getCleaning().getRestaurateur().getFirstName() + ' ' + item.getCleaning().getRestaurateur().getLastName() , tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        
        document.add(table);
    }

    private void addContentToDocumentPersonal(Document document, Integer requestedBy, List<Item> cleansedItems) throws DocumentException {
        // Add heading
        User user = userService.findById(requestedBy);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph heading = new Paragraph("Cleansed Items Report for " + user.getFirstName() + ' ' + user.getLastName(), font);
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);
        
        document.add(new Paragraph(" "));
        
        // Add meta information
        Font metaFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);        
        

        document.add(new Paragraph("Generated on: " + LocalDate.now().format(DateTimeFormatter.ISO_DATE), metaFont));
        document.add(new Paragraph("Requested by: " + user.getFirstName() + ' ' + user.getLastName(), metaFont));
        //document.add(new Paragraph("For the month: " + previousMonth.format(formatter), metaFont));
        
        document.add(new Paragraph(" "));
        
        // Create table
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{3, 2, 2, 2});
        
        Font tableHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        
        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Item", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Cleaning started", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Cleaning ended", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Cleaned By", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        Font tableFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        
        for (Item item : cleansedItems) {
            PdfPCell cell;
            
            cell = new PdfPCell(new Phrase(item.getName(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(item.getCleaning().getPutToCleaningTime().toString(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(item.getCleaning().getFinishCleaningTime().toString(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(item.getCleaning().getRestaurateur().getFirstName() + ' ' + item.getCleaning().getRestaurateur().getLastName(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        
        document.add(table);
    }

    private void addContentToRequestsDocument(Document document, Integer requestedBy, List<PersonalTourRequest> requests, boolean personal) throws DocumentException {
        User user = userService.findById(requestedBy);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        if (!personal){
            Paragraph heading = new Paragraph("Handled Personal Tour Requests Report", font);
            heading.setAlignment(Element.ALIGN_CENTER);
            document.add(heading);
        }
        else{
            Paragraph heading = new Paragraph("Handled Personal Tour Requests Report for " + user.getFirstName() + ' ' + user.getLastName(), font);
            heading.setAlignment(Element.ALIGN_CENTER);
            document.add(heading);
        }

        document.add(new Paragraph(" "));

        Font metaFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

        document.add(new Paragraph("Generated on: " + LocalDate.now().format(DateTimeFormatter.ISO_DATE), metaFont));
        document.add(new Paragraph("Requested by: " + user.getFirstName() + ' ' + user.getLastName(), metaFont));

        if (!personal){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            YearMonth previousMonth = YearMonth.now().minusMonths(1);
            document.add(new Paragraph("For the month: " + previousMonth.format(formatter), metaFont));
        }

        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{3, 2, 2, 2, 2, 4});

        Font tableHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Proposer", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Date and time", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Guest Number", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Exhibition number", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Status", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Denial Reason", tableHeaderFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        Font tableFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

        for (PersonalTourRequest request : requests) {
            PdfPCell cell;

            cell = new PdfPCell(new Phrase(request.getProposer().getFirstName() + ' ' +
                    request.getProposer().getLastName(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(request.getOccurrenceDateTime().toString(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(request.getGuestNumber(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            var exhibitionNumber = request.getExhibitions().size();
            cell = new PdfPCell(new Phrase(Integer.toString(exhibitionNumber), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(request.getStatus().toString(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(request.getDenialReason(), tableFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }

        document.add(table);
    }

}
