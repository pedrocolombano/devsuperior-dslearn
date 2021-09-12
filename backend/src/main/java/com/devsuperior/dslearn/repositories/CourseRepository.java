package com.devsuperior.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dslearn.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
