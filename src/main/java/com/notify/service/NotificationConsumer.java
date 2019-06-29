package com.notify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notify.model.NotificationData;

import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class NotificationConsumer implements Consumer<Event<NotificationData>> {

	@Autowired
	private NotificationService notificationService;

	public void accept(Event<NotificationData> notificationDataEvent) {
		NotificationData notificationData = notificationDataEvent.getData();
		System.out.println("In accept: " + notificationData.getId());
		try {
			notificationService.initiateNotification(notificationData);
		} catch (InterruptedException e) {
			System.out.println("Exception ::" + e);
		}
	}

}
