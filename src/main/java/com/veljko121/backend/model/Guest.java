package com.veljko121.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Guest extends User {

    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "guest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

}
