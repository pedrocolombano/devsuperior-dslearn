package com.devsuperior.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearn.dto.DeliverRevisionDTO;
import com.devsuperior.dslearn.entities.Deliver;
import com.devsuperior.dslearn.repositories.DeliverRepository;
import com.devsuperior.dslearn.services.exceptions.ResourceNotFoundException;

@Service
public class DeliverService {

	private DeliverRepository deliverRepository;

	@Autowired
	public DeliverService(DeliverRepository deliverRepository) {
		this.deliverRepository = deliverRepository;
	}
	
	@Transactional
	public void saveRevision(Long deliverId, DeliverRevisionDTO dto) {
		try {
			Deliver deliver = this.deliverRepository.getById(deliverId);
			deliver.setStatus(dto.getStatus());
			deliver.setFeedback(dto.getFeedback());
			deliver.setCorrectCount(dto.getCorrectCount());
			
			this.deliverRepository.save(deliver);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Deliver id not found");
		}
	}
	
}
