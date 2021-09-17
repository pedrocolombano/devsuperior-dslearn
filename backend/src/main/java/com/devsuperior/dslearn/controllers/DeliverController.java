package com.devsuperior.dslearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearn.dto.DeliverRevisionDTO;
import com.devsuperior.dslearn.services.DeliverService;

@RestController
@RequestMapping("/deliveries")
public class DeliverController {

	private DeliverService deliverService;

	@Autowired
	public DeliverController(DeliverService deliverService) {
		this.deliverService = deliverService;
	}
	
	@PreAuthorize("hasAnyRole('INSTRUCTOR', 'ADMIN')")
	@PutMapping("/{deliverId}")
	public ResponseEntity<Void> saveRevision(@PathVariable final Long deliverId, @RequestBody DeliverRevisionDTO revision) {
		this.deliverService.saveRevision(deliverId, revision);
		return ResponseEntity.noContent().build();
	}
	
}
