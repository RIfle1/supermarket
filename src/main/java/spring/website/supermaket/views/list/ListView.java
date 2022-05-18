package spring.website.supermaket.views.list;

import spring.website.supermaket.data.entity.Contact;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;



@PageTitle("Contacts")
@Route(value = "")
public class ListView extends VerticalLayout {

    Grid<Contact> grid = new Grid<>(Contact.class);
    TextField filterText = new TextField();

    public ListView() {
        addClassName("list-view");
        setSizeFull();

        configureGrid();
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();

    }

}
