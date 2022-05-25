package spring.website.supermarket.views.SupermarketComponents;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import spring.website.supermarket.data.entity.Product;

import java.util.List;

public class BasketViewList extends FormLayout {

    H2 cartText = new H2("Your Cart");

    VerticalLayout mainVerticalLayout = new VerticalLayout();
    VerticalLayout itemsLayout = new VerticalLayout();
    VerticalLayout checkoutInfoLayout = new VerticalLayout();


    public BasketViewList(List<Product> addedProducts) {
        cartText.addClassNames("text-3xl");
        mainVerticalLayout.add(cartText, itemsLayout, checkoutInfoLayout);
        mainVerticalLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        mainVerticalLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        mainVerticalLayout.addClassNames("bg-contrast-10");
        refreshBasket(addedProducts);
        add(mainVerticalLayout);
    }

    public void refreshBasket(List<Product> addedProducts) {
        itemsLayout.removeAll();
        addedProducts.forEach(product -> {
            itemsLayout.add(new BasketViewCard(
                    product.getProduct_photo(product.getProduct_id()),
                    product.getProduct_name(),
                    product.getProduct_price(),
                    product.getProduct_category()));
        });
    }

}
