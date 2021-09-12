package com.devsuperior.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dslearn.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
