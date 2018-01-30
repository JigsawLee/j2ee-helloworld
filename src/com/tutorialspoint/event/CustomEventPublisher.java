package com.tutorialspoint.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher mPublisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		// TODO Auto-generated method stub
		this.mPublisher = applicationEventPublisher;
	}

	public void publish() {
		CustomEvent event = new CustomEvent(this);
		mPublisher.publishEvent(event);
	}

}
