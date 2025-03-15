package com.vivah.makeUp_service.repository;

import com.vivah.makeUp_service.entity.MakeupArtists;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface MakeupArtistRepository extends JpaRepository<MakeupArtists, Long> {
    
/*
    // Filter by expertise (contains keyword)
    @Query("SELECT m FROM MakeupArtist m WHERE LOWER(m.expertise) LIKE LOWER(CONCAT('%', :expertise, '%'))")
    Page<MakeupArtists> findByExpertiseContaining(@Param("expertise") String expertise, Pageable pageable);
*/

}
