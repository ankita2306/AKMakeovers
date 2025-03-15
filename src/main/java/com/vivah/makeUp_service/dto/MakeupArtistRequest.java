package com.vivah.makeUp_service.dto;

import com.vivah.makeUp_service.entity.ArtistStatus;
import com.vivah.makeUp_service.entity.User;
import lombok.Data;
import java.util.List;

@Data
public class MakeupArtistRequest extends UserRequest {
    private User user;
    private String bio;
    private String adharNum;
    private Integer experience;
    private List<String> services;
    private String expertise;
    private Double rating;
    private String priceRange;
    private Boolean isVerified;
    private String location;
    private ArtistStatus status;
}
