package com.institute.one.courses.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institute.one.courses.persistence.model.CourseEntity;

public interface ICoursesRepository extends JpaRepository<CourseEntity, Long> {

    

}
