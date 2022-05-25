package spring.website.supermarket.views.SupermarketComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.StreamResource;

import java.util.Objects;

public class ProductImageViewCard extends ListItem {

    Div productCard = new Div();
    Image productImage = new Image();
    Span productName = new Span();
    Span productPrice = new Span();
    Paragraph productDesc = new Paragraph();
    Button addToCart = new Button("Add To Cart");

    public ProductImageViewCard(StreamResource product_photo, String product_name, String product_desc, String product_price, String category) {
        addClassNames("bg-contrast-20", "flex", "flex-col", "items-start", "p-m", "rounded-l");


        productCard.addClassNames(
                "flex items-center",
                "justify-center",
                "mb-m",
                "overflow-hidden",
                "rounded-m w-full");

        productCard.setHeight("100%");
        productCard.setWidth("100%");


        productImage.setWidth("100%");
        productImage.setHeight("100%");

        productImage.setSrc(product_photo);
        productImage.setAlt(product_name);

        productCard.add(productImage);


        productName.addClassNames("text-xl", "font-semibold");
        productName.setText(product_name);


        productPrice.addClassNames("text-s", "text-secondary");
        if(Objects.equals(category, "Fruits and Vegetables") || Objects.equals(category, "Meat, Fish and Culinary")) {
            productPrice.setText(product_price + "€/KG");
        }
        else {
            productPrice.setText(product_price + "€/Piece");
        }

        productDesc.setText(product_desc);
        productDesc.addClassName("my-m");

        add(
                productCard,
                productName,
                productPrice,
                productDesc,
                createButtonLayout()
        );

    }

    private Component createButtonLayout() {
        addToCart.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return new HorizontalLayout(addToCart);
    }



}
