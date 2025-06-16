package com.example.restgutendex.entity;


// Entidad Libro

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Book {

    @Id
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "autores")
    private String author;


}
