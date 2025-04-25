package com.example.FirstApi.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class GeoLocation {
    private String lat;
    @JsonProperty("long")
    private String lon;
}
