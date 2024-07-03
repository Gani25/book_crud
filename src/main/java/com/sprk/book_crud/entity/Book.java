package com.sprk.book_crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * DOCS Comment
 * 
 * @return
 * 
 * @author:
 * 
 */

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(columnDefinition = "double default 0")
    private double amount;

    @NotBlank(message = "Please add author name!!")
    @Column(length = 50)
    private String authorName;

    @NotBlank(message = "Please add book name!!")
    @Column(length = 50)
    private String bookName;

    @NotBlank(message = "Please add edition!!")
    private String edition;

    @NotBlank(message = "Please add publication!!")
    private String publication;

    @NotBlank(message = "Please add email!!")
    @Email(message = "Please enter valid email!!")
    private String email;
}