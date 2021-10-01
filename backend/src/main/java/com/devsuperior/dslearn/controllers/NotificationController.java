package com.devsuperior.dslearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearn.dto.NotificationDTO;
import com.devsuperior.dslearn.services.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	private NotificationService notificationService;

	@Autowired
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> notificationsForCurrentUser(
			@RequestParam(name = "unreadOnly", defaultValue = "false") Boolean unreadOnly,
			@PageableDefault(page = 0, size = 15, sort = "moment", direction = Direction.DESC) Pageable pageable) {
		Page<NotificationDTO> notifications = this.notificationService.notificationsForCurrentUser(unreadOnly, pageable);
		return ResponseEntity.ok(notifications);
	}

}
