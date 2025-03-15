package com.akMakeovers.makeUp_service.repository;

import com.akMakeovers.makeUp_service.entity.MakeupArtists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeupArtistRepository extends JpaRepository<MakeupArtists, Long> {
    
/*
    // Filter by expertise (contains keyword)
    @Query("SELECT m FROM MakeupArtist m WHERE LOWER(m.expertise) LIKE LOWER(CONCAT('%', :expertise, '%'))")
    Page<MakeupArtists> findByExpertiseContaining(@Param("expertise") String expertise, Pageable pageable);
*/

}
