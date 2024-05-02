package com.example.udemydemo.repository;

import com.example.udemydemo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAuthorByAge(@Param("age") int age);
    List<Author> findAllByName(String name);
    List<Author> findAllByNameContainingIgnoreCase(String name);
    List<Author> findAllByNameStartingWithIgnoreCase(String name);
    List<Author> findTop3ByOrderByAgeDesc();
    List<Author> findAuthorById(@Param("id") int id);
    List<Author> findByEmailContainingIgnoreCase(String mail);



}
