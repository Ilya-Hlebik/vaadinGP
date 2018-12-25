package com.gpsolution.vaadin.ui.entity;

import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

public class StringListField extends CustomField<List<String>> {

    private HorizontalLayout layout = (HorizontalLayout) initContent();

    @Override
    protected Component initContent() {
        return new HorizontalLayout();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<? extends List<String>> getType() {
        return (Class<List<String>>) ((List<String>) new ArrayList<String>()).getClass();
    }

    @Override
    public List<String> getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(final List<String> newFieldValue) {
        List<String> copy = newFieldValue;
        layout.removeAllComponents();
        TextField textField = new TextField();
        Button remove = new Button("remove");
        textField.addValueChangeListener(e -> fireValueChange(true));



        remove.addClickListener(e -> fireValueChange(true));
        for (String cop : copy) {
            layout.addComponents(textField, remove);
        }

    }
}
