package com.example.FirstApi.model.user;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Name {
    private String firstname;
    private String lastname;
}
