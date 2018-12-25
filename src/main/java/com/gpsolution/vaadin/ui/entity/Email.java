package com.gpsolution.vaadin.ui.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Email {

    private String name;
    private String text;
    private List<String> recipients;

    private Email(String name, String text, List<String> recipients) {
        this.name = name;
        this.text = text;
        this.recipients = recipients;
    }

    public Email() {
    }

    public List<Email> getContent() {
        return Arrays.asList(
                new Email("Demian", "Hello, have you done your homeworl?", Arrays.asList("Wladimir", "Pavel", "Iosif")),
                new Email("Wladimir", "I'm not going to do any homeworl! ", Collections.singletonList("Demian")),
                new Email("Demian", "Ok", Collections.singletonList("Wladimir"))
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }
}
