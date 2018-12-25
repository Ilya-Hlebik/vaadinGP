package com.gpsolution.vaadin.ui;

import com.gpsolution.vaadin.ui.entity.Email;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "vaadin")
@Theme("valo")
public class VaadinUI extends UI {
    private final VerticalLayout layout = new VerticalLayout();
    private final Email mails = new Email();
    private final BeanItemContainer<Email> emailBeanItemContainer = new BeanItemContainer<>(Email.class, mails.getContent());
    private final Grid grid = new Grid(emailBeanItemContainer);
    private final Button remove = new Button("Remove");


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        grid.setHeight("100%");
        grid.setWidth("100%");
        grid.removeColumn("content");

        layout.setHeight("100%");
        layout.setWidth("100%");
        layout.addComponent(grid);
        layout.addComponent(remove);

        remove.setEnabled(false);

        grid.setColumnOrder("message", "name", "recipients");
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        grid.addSelectionListener(e -> {
            if (e != null && !e.getSelected().isEmpty()) {
                remove.setEnabled(true);
            } else if (e != null && e.getSelected().isEmpty()) {
                remove.setEnabled(false);
            }
        });

        remove.addClickListener(click -> {

            for (Object row : grid.getSelectedRows()) {
                grid.getContainerDataSource().removeItem(row);
            }
            remove.setEnabled(false);
        });


        setContent(layout);
    }
}
