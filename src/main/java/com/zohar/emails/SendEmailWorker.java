package com.zohar.emails;

public class SendEmailWorker implements Runnable {
    private final EmailProvider provider;

    public SendEmailWorker(EmailProvider provider) {
        this.provider = provider;
    }

    @Override
    public void run() {
        System.out.println("Sending email using the following provider details: " + provider);
        // ...Send an email using this.provider data
    }
}
