package com.example.udemydemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true) //default false olarak gelir.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
public class Author extends BaseEntity{
    {
        courses = new ArrayList<>(); //her bir author nesnesi oluştuğunda courses listi boş olarak başlatılır.
    }

    @Column(name = "name")
    @Size(min = 3, max = 20)
    private String name;

    @Column(name = "surname")
    @Size(min =2, max = 20)
    private String surname;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @NotBlank
    private int age;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Course> courses;
}
