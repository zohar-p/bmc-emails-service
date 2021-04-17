package com.zohar.emails;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

@Service
public class EmailsService {
    private final HashMap<String, EmailProvider> providersByName = new HashMap<>();

    public EmailsService() {
        this.providersByName.put("gmail", new EmailProvider("smtp.gmail.com", "admin", "admin", "@gmail.com"));
        this.providersByName.put("walla", new EmailProvider("smtp.walla.co.il", "admin", "admin", "@walla.co.il"));
        this.providersByName.put("yahoo", new EmailProvider("smtp.yahoo.com", "admin", "admin", "@yahoo.com"));
    }

    public String determineProvider(String senderEmail) {
        String domain = senderEmail.split("@")[1];
        String providerName = domain.split("\\.")[0];
        return providerName.toLowerCase(Locale.ROOT);
    }

    public void sendEmail(String providerName, SendEmailForm emailConfig) throws InterruptedException {
        EmailProvider provider = this.providersByName.get(providerName);
        Runnable sendEmailWorker = new SendEmailWorker(provider);
        Thread sendEmailJob = new Thread(sendEmailWorker);
        sendEmailJob.start();
        sendEmailJob.join();
    }
}
