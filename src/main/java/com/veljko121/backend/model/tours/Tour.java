package com.veljko121.backend.model.tours;

import com.veljko121.backend.model.Curator;
import com.veljko121.backend.model.Organizer;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String description;

    //@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = false)
    //private List<Room> rooms = new ArrayList<>();         Soba jos ne postoji tek kada se bude spojila grana treba otkomentarisati

    @NotEmpty
    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private LocalDateTime occurrenceDateTime;

    @NotEmpty
    @Column(nullable = false)
    private String adultTicketPrice;

    @NotEmpty
    @Column(nullable = false)
    private String minorTicketPrice;

    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Curator guide;          // Da li samo kustos ili moze da bude i recimo gostujuci predavac

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @NotEmpty
    @Column(nullable = false)
    private String picturePath;

    @NotEmpty
    @Column(nullable = false)
    private String capacity;

}
