package com.akMakeovers.makeUp_service.controller;

import com.akMakeovers.makeUp_service.dto.MakeupArtistRequest;
import com.akMakeovers.makeUp_service.dto.MakeupArtistResponse;
import com.akMakeovers.makeUp_service.entity.MakeupArtists;
import com.akMakeovers.makeUp_service.service.MakeupArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/akm")
public class MakeupArtistController {

    @Autowired
    private MakeupArtistService makeupArtistService;

    // GET: Retrieve all makeup artists
    @GetMapping("/allMakeUpArtists")
    public ResponseEntity<List<MakeupArtists>> getAllMakeupArtists() {
        List<MakeupArtists> artists = makeupArtistService.getAllMakeupArtists();
        return ResponseEntity.ok(artists);
    }

    // POST: Create a new makeup artist
    @PostMapping("/addArtist")
    public ResponseEntity<MakeupArtists> createMakeupArtist(@Valid @RequestBody MakeupArtistRequest dto) {
        MakeupArtists newArtist = makeupArtistService.createMakeupArtist(dto);
        return ResponseEntity.ok(newArtist);
    }

  /*  @GetMapping("/search")
    public List<MakeupArtistDTO> getArtistsByExpertise(@RequestParam String expertise) {
        return makeupArtistService.getArtistsByExpertise(expertise);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<MakeupArtists> getArtistById(@PathVariable Long id) {
        MakeupArtists artist = makeupArtistService.getArtistById(id);
        return ResponseEntity.ok(artist);
    }

    @PutMapping("/update/{id}")    //not tested
    public ResponseEntity<MakeupArtists> updateArtist(
            @PathVariable Long id,
            @RequestBody MakeupArtists updatedArtist) {
        MakeupArtists updated = makeupArtistService.updateArtist(id, updatedArtist);
        return ResponseEntity.ok(updated);
    }
}
