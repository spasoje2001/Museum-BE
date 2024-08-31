package com.veljko121.backend.model;

import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.enums.ExhibitionTheme;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Document(indexName = "exhibitions")
@Getter
@Setter
public class ExhibitionSearch {
    @Id
    private String id;

    private Integer relationalDbId;

    private String name;

    private String shortDescription;

    private String longDescription;

    private ExhibitionTheme theme;

    private ExhibitionStatus status;

    @Field(type = FieldType.Date)
    private LocalDate startDate;

    @Field(type = FieldType.Date)
    private LocalDate endDate;

    private String organizer;

    private String curator;

    private Collection<ItemSearch> items;

    private Collection<ReviewSearch> reviews;

    public Double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        Double averageRating = 0.;
        for (ReviewSearch review : reviews) {
            averageRating += review.getRating();
        }
        return averageRating / reviews.size();
    }

}
