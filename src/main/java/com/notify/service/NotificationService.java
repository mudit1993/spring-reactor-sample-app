package com.notify.service;

import com.notify.model.NotificationData;

public interface NotificationService {
	 
    public void initiateNotification(NotificationData notificationData) 
      throws InterruptedException;
 
}