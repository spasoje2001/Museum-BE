package com.veljko121.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;  // Veza sa korisnikom koji je napisao recenziju, ukoliko je null -> anoniman komentar

    @ManyToOne
    @JoinColumn(name = "exhibition_id", nullable = false)
    private Exhibition exhibition;  // Veza sa izložbom za koju je komentar napisan

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;  // Tekstualni komentar korisnika

    // Rekurzivna veza - komentar može biti odgovor na drugi komentar
    @ManyToOne
    @JoinColumn(name = "parent_comment_id", nullable = true)
    private Comment parentComment;  // Referenca na roditeljski komentar (ako postoji)

    @CreationTimestamp
    @Column(name = "comment_date",nullable = false, updatable = false)
    private LocalDate commentDate;  // Datum kada je komentar napisan

    // Konstruktor sa svim parametrima
    public Comment(User user, Exhibition exhibition, String text, Comment parentComment) {
        this.user = user;
        this.exhibition = exhibition;
        this.text = text;
        this.parentComment = parentComment;
    }
}
