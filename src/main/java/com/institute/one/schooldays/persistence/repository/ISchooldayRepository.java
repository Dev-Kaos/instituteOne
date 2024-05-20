package com.institute.one.schooldays.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.one.schooldays.persistence.model.SchooldayEntity;

@Repository
public interface ISchooldayRepository extends JpaRepository<SchooldayEntity, Long> {

    List<SchooldayEntity> findAllByNameContaining(String name);

    List<SchooldayEntity> findAllByDescriptionContaining(String description);

    // List<SchooldayEntity> findAllByStateContaining(String state);

}
