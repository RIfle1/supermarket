package spring.website.supermarket.views.SupermarketComponents;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.server.StreamResource;

import java.util.Objects;

public class BasketViewCard extends Div {

    public BasketViewCard(StreamResource product_photo, String product_name, String product_price, String category) {
        addClassNames("bg-contrast-20", "flex", "flex-col", "items-start", "p-m", "rounded-l");

        Div div = new Div();
        div.addClassNames(
                "flex items-center",
                "overflow-hidden",
                "rounded-m w-full");
        div.setHeight("100px");
        div.setWidth("300px");

        Image productImage = new Image();
        productImage.setWidth("90px");
        productImage.setHeight("90px");
        productImage.addClassNames("rounded-m w-full", "m-s");

        productImage.setSrc(product_photo);
        productImage.setAlt(product_name);



        Span productName = new Span();
        productName.addClassNames("text-xl", "font-semibold", "m-s");
        productName.setText(product_name);

        Span productPrice = new Span();
        productPrice.addClassNames("text-s", "text-secondary", "m-s");
        if(Objects.equals(category, "Fruits and Vegetables") || Objects.equals(category, "Meat, Fish and Culinary")) {
            productPrice.setText(product_price + "€/KG");
        }
        else {
            productPrice.setText(product_price + "€/Piece");
        }

        div.add(productImage, productName, productPrice);

        add(div);
    }
}
