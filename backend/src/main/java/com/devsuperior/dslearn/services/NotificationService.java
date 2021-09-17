package com.devsuperior.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearn.dto.NotificationDTO;
import com.devsuperior.dslearn.entities.Notification;
import com.devsuperior.dslearn.entities.User;
import com.devsuperior.dslearn.repositories.NotificationRepository;

@Service
public class NotificationService {

	private NotificationRepository notificationRepository;

	private AuthService authService;
	
	@Autowired
	public NotificationService(NotificationRepository notificationRepository, AuthService authService) {
		this.notificationRepository = notificationRepository;
		this.authService = authService;
	}
	
	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationsForCurrentUser(final Pageable pageable) {
		User user = this.authService.authenticated();
		Page<Notification> notifications = this.notificationRepository.findByUser(user, pageable);
		return notifications.map(n -> new NotificationDTO(n));
	}
	
}
