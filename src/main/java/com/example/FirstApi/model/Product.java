package com.example.FirstApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Product {

    @Id
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    @Embedded
    private Rating rating;

}
