package com.gpsolution.vaadin.ui;

import com.gpsolution.vaadin.ui.entity.Email;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "vaadin")
@Theme("valo")
public class VaadinUI extends UI {
    private final VerticalLayout layout = new VerticalLayout();
    private final Grid grid = new Grid();
    private final Email mail = new Email();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        grid.setHeight("100%");
        grid.setWidth("100%");
        layout.setHeight("100%");
        layout.setWidth("100%");

        grid.addColumn("Name");
        grid.addColumn("Message");
        grid.addColumn("Recipient");
        for (Email email : mail.getContent()) {
            grid.addRow(email.getName(), email.getText(), email.getRecipients().toString());
        }
        layout.addComponent(grid);
        setContent(layout);
    }
}
