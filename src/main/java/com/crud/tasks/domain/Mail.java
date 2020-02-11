package com.crud.tasks.domain;

import com.crud.tasks.service.mail.MailCreatorService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Mail {
    private String receiverEmail;
    private String toCC;
    private String subject;
    private String message;
    private String text;

    public Mail(final String receiverEmail, final String toCC, final String subject, final String message) {
        this.receiverEmail = receiverEmail;
        this.toCC = toCC;
        this.subject = subject;
        this.message = message;
    }

    public Mail(final String receiverEmail, final String subject, final String message, MailCreatorService mailCreatorService) {
        this.receiverEmail = receiverEmail;
        this.subject = subject;
        this.message = message;
        this.text = mailCreatorService.createMail(message);
    }
}