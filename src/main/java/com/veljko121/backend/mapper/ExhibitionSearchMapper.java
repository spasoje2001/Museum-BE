package com.veljko121.backend.mapper;


import com.veljko121.backend.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExhibitionSearchMapper {
    public ExhibitionSearch toExhibitionSearch(Exhibition exhibition) {
        if (exhibition == null) {
            return null;
        }

        ExhibitionSearch searchExhibition = new ExhibitionSearch();

        // Basic Fields
        searchExhibition.setRelationalDbId(exhibition.getId());
        searchExhibition.setName(exhibition.getName());
        searchExhibition.setShortDescription(exhibition.getShortDescription());
        searchExhibition.setLongDescription(exhibition.getLongDescription());
        searchExhibition.setTheme(exhibition.getTheme());
        searchExhibition.setStatus(exhibition.getStatus());
        searchExhibition.setStartDate(exhibition.getExhibitionProposal().getStartDate());
        searchExhibition.setEndDate(exhibition.getExhibitionProposal().getEndDate());

        // Mapping Organizer and Curator
        searchExhibition.setOrganizer(mapOrganizer(exhibition.getExhibitionProposal().getOrganizer()));
        searchExhibition.setCurator(mapCurator(exhibition.getCurator()));

        // Mapping Items and Reviews
        searchExhibition.setItems(mapItems(exhibition.getItemReservations()));
        searchExhibition.setReviews(mapReviews(exhibition.getReviews()));

        return searchExhibition;
    }

    // Helper method to map Organizer to String
    private String mapOrganizer(Organizer organizer) {
        if (organizer == null) {
            return null;
        }
        return organizer.getFirstName() + " " + organizer.getLastName();
    }

    // Helper method to map Curator to String
    private String mapCurator(Curator curator) {
        if (curator == null) {
            return null;
        }
        return curator.getFirstName() + " " + curator.getLastName();
    }

    // Helper method to map ItemReservation list to SearchItem list
    private List<ItemSearch> mapItems(List<ItemReservation> itemReservations) {
        return itemReservations.stream()
                .map(itemReservation -> {
                    ItemSearch searchItem = new ItemSearch();
                    searchItem.setName(itemReservation.getItem().getName());
                    searchItem.setDescription(itemReservation.getItem().getDescription());
                    searchItem.setAuthorsName(itemReservation.getItem().getAuthorsName());
                    searchItem.setPeriod(itemReservation.getItem().getPeriod());
                    searchItem.setCategory(itemReservation.getItem().getCategory());
                    return searchItem;
                })
                .collect(Collectors.toList());
    }

    // Helper method to map Review list to SearchReview list
    private List<ReviewSearch> mapReviews(List<Review> reviews) {
        return reviews.stream()
                .map(review -> {
                    ReviewSearch searchReview = new ReviewSearch();
                    searchReview.setGuestName(review.getGuest().getFirstName() + " " + review.getGuest().getLastName());
                    searchReview.setRating(review.getRating());
                    searchReview.setComment(review.getComment());
                    return searchReview;
                })
                .collect(Collectors.toList());
    }
}
