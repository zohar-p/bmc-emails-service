package com.zohar.emails;

public class EmailProvider {
    private String serverAddress;
    private String username;
    private String password;
    private String emailPostfix;

    public String getServerAddress() {
        return serverAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailPostfix() {
        return emailPostfix;
    }

    public EmailProvider(String serverAddress, String username, String password, String emailPostfix) {
        this.serverAddress = serverAddress;
        this.username = username;
        this.password = password;
        this.emailPostfix = emailPostfix;
    }
}