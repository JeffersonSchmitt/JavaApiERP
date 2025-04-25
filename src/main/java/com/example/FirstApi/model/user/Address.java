package com.example.FirstApi.model.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
@Embeddable
public class Address {
    @Embedded
    private GeoLocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;
}
