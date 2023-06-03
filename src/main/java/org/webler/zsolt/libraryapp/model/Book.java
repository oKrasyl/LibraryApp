package org.webler.zsolt.libraryapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;

    @ISBN
    private String isbn;

    @Size(min = 3, max = 50, message = "Title must be between 20 and 255 characters")
    private String title;

    @Size(min = 20, max = 255, message = "Description must be between 20 and 255 characters")
    private String description;

    @PositiveOrZero
    private int pageCount;

    @NotBlank
    private String genre;

    private boolean available;

    @JsonIgnore
    @ManyToMany(mappedBy = "publishedBooks")
    private Set<Author> author;


}
