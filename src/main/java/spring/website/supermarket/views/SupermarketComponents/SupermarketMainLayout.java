package spring.website.supermarket.views.SupermarketComponents;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class SupermarketMainLayout extends AppLayout {

    public SupermarketMainLayout() {
        addToNavbar(createHeader());
    }

    private HorizontalLayout createHeader() {
        H1 logo = new H1("Supermarket");
        logo.addClassNames("text-2xl", "m-m", "justify-center");

        TextField searchBar = new TextField();
        searchBar.setPlaceholder("Search Products");

        Button profileButton = new Button("User", new Icon(VaadinIcon.USER));
        profileButton.setIconAfterText(true);

        Button logOutButton = new Button("Log out");

        HorizontalLayout topHeader = new HorizontalLayout();
        topHeader.setPadding(true);
        topHeader.add(logo, searchBar, profileButton, logOutButton);
        topHeader.addClassNames("bg-contrast-10");
        topHeader.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        topHeader.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        topHeader.setWidthFull();
        topHeader.setHeight("100px");

        return topHeader;
    }
}
