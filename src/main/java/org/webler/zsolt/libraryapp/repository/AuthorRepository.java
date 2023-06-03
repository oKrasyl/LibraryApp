package org.webler.zsolt.libraryapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.libraryapp.model.Author;

import java.util.List;
import java.util.Optional;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findAllAuthorByName(String Name);

}
