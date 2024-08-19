package com.veljko121.backend.model;

import com.veljko121.backend.core.enums.ItemCategory;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String authorsName;

    @Column(nullable = true)
    private String yearOfCreation;

    @NotEmpty
    @Column(nullable = false)
    private String period;

    @Enumerated
    private ItemCategory category;

    @NotEmpty
    @Column(nullable = false)
    private String picture;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemReservation> itemReservations = new ArrayList<>();

    public Item(String name, String description, String authorsName, String yearOfCreation, String period, ItemCategory category, String picture) {
        this.name = name;
        this.description = description;
        this.authorsName = authorsName;
        this.yearOfCreation = yearOfCreation;
        this.period = period;
        this.category = category;
        this.picture = picture;
    }

}
