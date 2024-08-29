package com.veljko121.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Veza sa korisnikom kojem je obaveštenje upućeno


    @Column(length = 1000)
    private String message;  // Poruka obaveštenja

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;  // Datum i vreme kada je obaveštenje kreirano, postavlja se automatski

    @Column(nullable = false)
    private boolean isRead = false;  // Oznaka da li je obaveštenje pročitano

    // Konstruktor sa svim parametrima osim timestamp (koji se postavlja automatski)
    public Notification(User user, String message) {
        this.user = user;
        this.message = message;
    }

    // Metoda za označavanje obaveštenja kao pročitanog
    public void markAsRead() {
        this.isRead = true;
    }
}
