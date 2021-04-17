package com.zohar.emails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SendEmailForm {

    @Email
    @NotEmpty
    private String from;

    @Email
    @NotEmpty
    private String to;

    @NotEmpty
    private String body;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "EmailForm(" + "from: " + this.from + ", to: " + this.to + ", body: " + this.body + ")";
    }
}