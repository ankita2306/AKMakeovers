package com.akMakeovers.makeUp_service.repository;

import com.akMakeovers.makeUp_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
