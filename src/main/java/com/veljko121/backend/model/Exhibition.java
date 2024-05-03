package com.veljko121.backend.model;

import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.enums.ExhibitionTheme;
import com.veljko121.backend.model.tours.PersonalTour;
import com.veljko121.backend.model.tours.PersonalTourRequest;
import com.veljko121.backend.model.tours.Tour;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Exhibition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    private String picture;

    @Column
    private String shortDescription;

    @Column
    private String longDescription;

    @Enumerated(EnumType.STRING)
    private ExhibitionTheme theme;

    @Enumerated(EnumType.STRING)
    private ExhibitionStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate; // Nullable, null means it's a permanent exhibition

    @PositiveOrZero
    @Column(nullable = false)
    private Integer price; // The price in whole euros

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "curator_id")
    private Curator curator;

    @OneToMany(mappedBy = "exhibition", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<RoomReservation> roomReservations;

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public void assignCurator(Curator newCurator) {
        // If there's an existing curator, remove this exhibition from their list
//        if (this.curator != null) {
//            this.curator.getExhibitions().remove(this);
//        }
//        // Assign the new curator
//        this.curator = newCurator;
//        // If the new curator is not null, add this exhibition to their list
//        if (newCurator != null) {
//            newCurator.getExhibitions().add(this);
//        }
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "tours_exhibitions", joinColumns = @JoinColumn(name = "tour_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "exhibition_id", referencedColumnName = "id"))
    private List<Tour> tours = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "peronal_tours_exhibitions",
            joinColumns = @JoinColumn(name = "personal_tour_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "exhibition_id", referencedColumnName = "id"))
    private List<PersonalTour> personalTours = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "peronal_tour_requests_exhibitions",
            joinColumns = @JoinColumn(name = "personal_tour_request_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "exhibition_id", referencedColumnName = "id"))
    private List<PersonalTourRequest> personalTourRequests = new ArrayList<>();

    public boolean isPermanent() {
        return endDate == null;
    }

    public boolean isTemporary() {
        return endDate != null;
    }

    public boolean isOngoing() {
        Date currentDate = new Date();
        // The exhibition is ongoing if it has started and either has no end date (permanent) or hasn't ended yet (temporary).
        return !currentDate.before(startDate) && (endDate == null || currentDate.before(endDate));
    }

    public boolean isFree() {
        return price == null || price == 0;
    }

}
