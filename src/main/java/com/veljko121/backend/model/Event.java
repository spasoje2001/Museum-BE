package com.veljko121.backend.model;

import java.time.Duration;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(nullable = false)
    private String name;
    
    @Column
    private String description;
    
    @NotNull
    @Column(nullable = false)
    private LocalDateTime startDateTime;
    
    @NotNull
    @Column(nullable = false)
    private Duration duration;
    
    @Positive
    @Column(nullable = false)
    private Integer ticketsNumber;
    
    @Positive
    @Column(nullable = false)
    private Integer price;
    
    @ManyToOne
    @NotNull
    private Organizer organizer;

    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    @Setter(value = AccessLevel.PRIVATE)
    private LocalDateTime createdDateTime;

}
