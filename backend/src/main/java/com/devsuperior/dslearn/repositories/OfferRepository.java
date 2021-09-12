package com.devsuperior.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dslearn.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}
