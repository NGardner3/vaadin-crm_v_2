package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.entity.Contact;
import com.vaadin.tutorial.crm.backend.service.ContactService;

/**
 * A Designer generated component for the my-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Route("")
@Tag("my-view")
@JsModule("./src/views/my-view.js")
public class MyView extends PolymerTemplate<MyView.MyViewModel> {
    @Id("filterText")
    private TextField filterText;
    @Id("grid")
    private Grid<Contact> grid;
    @Id("addContactButton")
    private Button addContactButton;

    private ContactService contactService;

    public MyView(ContactService contactService) {
        this.contactService = contactService;
        // You can initialise any data required for the connected UI components here.
        grid.addColumn(Contact::getFirstName).setHeader("First name");
        grid.addColumn(Contact::getLastName).setHeader("Last name");
        grid.addColumn(Contact::getEmail).setHeader("Email");
        grid.addColumn(Contact::getStatus).setHeader("Status");
        grid.addColumn(contact -> {
            Company company = contact.getCompany();
            return company == null ? "-" : company.getName();
        }).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        updateList();
    }

    private void updateList() {
        grid.setItems(contactService.findAll());
    }


    /**
     * This model binds properties between MyView and my-view
     */
    public interface MyViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
