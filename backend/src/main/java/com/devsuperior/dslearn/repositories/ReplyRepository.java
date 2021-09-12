package com.devsuperior.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dslearn.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
