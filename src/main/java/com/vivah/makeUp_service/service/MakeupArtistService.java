package com.vivah.makeUp_service.service;


import com.vivah.makeUp_service.dto.MakeupArtistRequest;
import com.vivah.makeUp_service.dto.UserRequest;
import com.vivah.makeUp_service.entity.MakeupArtists;

import java.util.List;


public interface MakeupArtistService {
    List<MakeupArtists> getAllMakeupArtists();

    MakeupArtists createMakeupArtist(MakeupArtistRequest artistRequest);
}
