package com.vivah.makeUp_service.service;

import com.vivah.makeUp_service.dto.MakeupArtistRequest;

import com.vivah.makeUp_service.entity.MakeupArtists;
import com.vivah.makeUp_service.entity.Role;

import com.vivah.makeUp_service.entity.User;
import com.vivah.makeUp_service.repository.MakeupArtistRepository;
import com.vivah.makeUp_service.repository.UserRepository;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeupArtistServiceImpl implements MakeupArtistService {

    private static final Logger logger = LoggerFactory.getLogger(MakeupArtistServiceImpl.class);

    @Autowired
    private MakeupArtistRepository makeupArtistRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<MakeupArtists> getAllMakeupArtists() {
        return makeupArtistRepository.findAll();
    }

    @Transactional
    @Override
    public MakeupArtists createMakeupArtist(MakeupArtistRequest artistRequest) {
        // Create User entity
        User user = new User();
        user.setName(artistRequest.getName());
        user.setEmail(artistRequest.getEmail());
        user.setPhone(artistRequest.getPhone());
        user.setPassword(artistRequest.getPassword()); // Encrypt password
        user.setRole(Role.MAKEUP_ARTIST);

        user = userRepository.save(user); // Save User first
        logger.debug("Saved User: {}", user);

        // Create Makeup Artist entity
        MakeupArtists artist = new MakeupArtists();
        artist.setBio(artistRequest.getBio());
        artist.setAdharNum(artistRequest.getAdharNum());
        artist.setExperience(artistRequest.getExperience());
        artist.setExpertise(artistRequest.getExpertise());
        artist.setRating(artistRequest.getRating());
        artist.setPriceRange(artistRequest.getPriceRange());
        artist.setIsVerified(artistRequest.getIsVerified());
        artist.setLocation(artistRequest.getLocation());
        artist.setStatus(artistRequest.getStatus());
        artist.setServices(artistRequest.getServices());

        // Set User reference (correct way)
        artist.setUser(user);

        logger.debug("Received Email: {}", artistRequest.getEmail());

        return makeupArtistRepository.save(artist);
    }

}
