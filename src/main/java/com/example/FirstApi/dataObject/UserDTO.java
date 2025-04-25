package com.example.FirstApi.dataObject;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String phone;
    private String city;
    private String street;
    private Integer number;
    private String zipcode;
    private String latitude;
    private String longitude;
}
