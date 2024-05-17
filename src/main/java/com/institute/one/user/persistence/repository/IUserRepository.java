package com.institute.one.user.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.institute.one.user.persistence.model.UserEntity;
import java.util.List;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
    
    // @Query("select u  from UserEntity u where username")
    // Optional<UserEntity> findByUser(String username);
    
}
