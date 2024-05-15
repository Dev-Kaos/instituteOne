package com.institute.one.user.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.one.user.persistence.model.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
