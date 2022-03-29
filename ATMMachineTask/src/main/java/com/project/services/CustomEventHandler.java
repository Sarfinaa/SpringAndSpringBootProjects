package com.project.services;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<WithdrawalEvent> {
	@Override
	public void onApplicationEvent(WithdrawalEvent event) {
		event.message();
    }

}