package com.veljko121.backend.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Organizer extends User{

    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

}
