package com.veljko121.backend.repository;

import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.enums.ExhibitionTheme;
import com.veljko121.backend.core.enums.ItemCategory;
import com.veljko121.backend.model.ExhibitionSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExhibitionSearchRepository extends ElasticsearchRepository<ExhibitionSearch, String> {
    Optional<ExhibitionSearch> findByRelationalDbId(Integer relationalDbId);

    // Pretraga po nazivu izložbe sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByNameContaining(String name);

    // Pretraga po kratkom opisu sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByShortDescriptionContaining(String shortDescription);

    // Pretraga po dugom opisu sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByLongDescriptionContaining(String longDescription);

    // Pretraga po temi (tačno podudaranje)
    List<ExhibitionSearch> findByTheme(ExhibitionTheme theme);

    // Pretraga po statusu (tačno podudaranje)
    List<ExhibitionSearch> findByStatus(ExhibitionStatus status);

    // Pretraga po početnom datumu (veće ili jednako zadatom datumu)
    List<ExhibitionSearch> findByStartDateAfter(LocalDate startDate);

    // Pretraga po krajnjem datumu (manje ili jednako zadatom datumu)
    List<ExhibitionSearch> findByEndDateBefore(LocalDate endDate);

    // Pretraga po imenu organizatora sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByOrganizerContaining(String organizer);

    // Pretraga po imenu kustosa sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByCuratorContaining(String curator);

    // Pretraga po nazivu predmeta u izložbi sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByItems_NameContaining(String itemName);

    // Pretraga po opisu predmeta sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByItems_DescriptionContaining(String itemDescription);

    // Pretraga po imenu autora predmeta sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByItems_AuthorsNameContaining(String authorsName);

    // Pretraga po kategoriji predmeta (tačno podudaranje)
    List<ExhibitionSearch> findByItems_Category(ItemCategory category);

    // Pretraga po periodu predmeta sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByItems_PeriodContaining(String period);

    // Pretraga po minimalnoj prosečnoj oceni (veće ili jednako zadatom)
    List<ExhibitionSearch> findByAverageRatingGreaterThanEqual(Double minRating);

    // Pretraga po komentaru sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByReviews_CommentContaining(String comment);

    // Pretraga po imenu gosta sa podrškom za slovne greške i delimične podudarnosti
    List<ExhibitionSearch> findByReviews_GuestNameContaining(String guestName);


}
