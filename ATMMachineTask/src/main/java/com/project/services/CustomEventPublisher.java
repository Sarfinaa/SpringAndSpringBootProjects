package com.project.services;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import com.project.BankAccount;

public class CustomEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
@Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

     public void publish(int amount, BankAccount acc) {
     WithdrawalEvent ce = new WithdrawalEvent(this);
     ce.setAmount(amount);
     ce.setBankAccount(acc);
     publisher.publishEvent(ce);
     }
}