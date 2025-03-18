package com.akMakeovers.makeUp_service.service;

import com.akMakeovers.makeUp_service.dto.MakeupArtistRequest;
import com.akMakeovers.makeUp_service.entity.MakeupArtists;
import com.akMakeovers.makeUp_service.entity.Role;
import com.akMakeovers.makeUp_service.entity.User;
import com.akMakeovers.makeUp_service.exception.DuplicateUserException;
import com.akMakeovers.makeUp_service.exception.ResourceNotFoundException;
import com.akMakeovers.makeUp_service.repository.MakeupArtistRepository;
import com.akMakeovers.makeUp_service.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        try{  // Create User entity
            User user = new User();
            user.setName(artistRequest.getName());
            user.setEmail(artistRequest.getEmail());
            user.setPhone(artistRequest.getPhone());
            user.setPassword(artistRequest.getPassword()); // Encrypt password
            user.setRole(Role.MAKEUP_ARTIST);
            user.getCreatedAt();
            user.getUpdatedAt();

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
            artist.setUser(user);

            logger.debug("Received Email: {}", artistRequest.getEmail());

            return makeupArtistRepository.save(artist);
        }
        catch (DuplicateUserException e)
        {
            throw e;
        }
        catch (DataIntegrityViolationException e) {
            throw new DuplicateUserException("You are already registered!!!");
        } catch (Exception e) {
            throw new RuntimeException("Error creating makeup artist", e);
        }
    }

    @Override
    public MakeupArtists getArtistById(Long artistId) {

        return makeupArtistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("MakeUpArtist not found for User ID: " + artistId));
    }

    @Override
    public MakeupArtists updateArtist(Long id, MakeupArtists updatedArtist) {
        return makeupArtistRepository.findById(id)
                .map(existingArtist -> {
                    existingArtist.setBio(updatedArtist.getBio());
                    existingArtist.setAdharNum(updatedArtist.getAdharNum());
                    existingArtist.setExperience(updatedArtist.getExperience());
                    existingArtist.setServices(updatedArtist.getServices());
                    existingArtist.setExpertise(updatedArtist.getExpertise());
                    existingArtist.setRating(updatedArtist.getRating());
                    existingArtist.setPriceRange(updatedArtist.getPriceRange());
                    existingArtist.setIsVerified(updatedArtist.getIsVerified());
                    existingArtist.setLocation(updatedArtist.getLocation());
                    existingArtist.setStatus(updatedArtist.getStatus());

                    return makeupArtistRepository.save(existingArtist);
                })
                .orElseThrow(() -> new EntityNotFoundException("Makeup Artist not found with id: " + id));
    }
}
