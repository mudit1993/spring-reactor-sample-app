package com.notify.service;

import org.springframework.stereotype.Service;

import com.notify.model.NotificationData;

@Service
public class NotificationServiceimpl implements NotificationService {
     
	public void initiateNotification(NotificationData notificationData) 
		      throws InterruptedException {
 
      System.out.println("Notification service started for "
        + "Notification ID: " + notificationData.getId());
         
      Thread.sleep(5000);
         
      System.out.println("Notification service ended for "
        + "Notification ID: " + notificationData.getId());
    }
}