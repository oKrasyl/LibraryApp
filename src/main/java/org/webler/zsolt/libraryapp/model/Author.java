package org.webler.zsolt.libraryapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webler.zsolt.libraryapp.validator.AlphaNumeric;
import org.webler.zsolt.libraryapp.validator.PhoneNumber;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Username cannot be null")
    @AlphaNumeric
    @Size(min = 5, max = 30, message = "Author name must be between 10 and 30 characters")
    private String name;

    @Size(min = 20, max = 255, message = "AboutMe must be between 20 and 255 characters")
    private String aboutMe;

    @PhoneNumber
    private String phoneNumber;

    @Email
    private String email;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "wroted_by",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> publishedBooks;


}
