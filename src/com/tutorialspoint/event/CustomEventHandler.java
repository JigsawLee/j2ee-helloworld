package com.tutorialspoint.event;

import org.springframework.context.ApplicationListener;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogUtils;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {

	public void onApplicationEvent(CustomEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.toString());
	}

}
