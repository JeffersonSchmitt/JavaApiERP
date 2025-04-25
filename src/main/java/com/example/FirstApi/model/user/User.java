package com.example.FirstApi.model.user;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long id;
    @Embedded
    private Name name;
    @Embedded
    private Address address;
    private String email;
    private String username;
    private String password;
    private String phone;
}
