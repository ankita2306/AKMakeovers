package com.akMakeovers.makeUp_service.service;


import com.akMakeovers.makeUp_service.dto.MakeupArtistRequest;
import com.akMakeovers.makeUp_service.entity.MakeupArtists;

import java.util.List;


public interface MakeupArtistService {
    List<MakeupArtists> getAllMakeupArtists();

    MakeupArtists createMakeupArtist(MakeupArtistRequest artistRequest);
}
