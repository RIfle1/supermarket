package spring.website.supermarket.views.SupermarketComponents;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import spring.website.supermarket.data.entity.Product;

import java.util.List;

public class ProductImageView extends Main implements HasComponents, HasStyle {


    OrderedList productImageContainer = new OrderedList();

    public ProductImageView(String category, List<Product> allProducts) {

        constructUI(category);

        allProducts.forEach(product -> {
            productImageContainer.add(new ProductImageViewCard(
                    product.getProduct_photo(product.getProduct_id()),
                    product.getProduct_name(),
                    product.getProduct_desc(),
                    product.getProduct_price(),
                    category));
        });
    }

    private void constructUI(String category) {
        addClassNames("image-list-view", "max-w-screen-lg", "mx-auto", "pb-l", "px-l");

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames("items-center", "justify-between");
        container.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        H2 header = new H2(category);
        header.addClassNames("text-3xl");

        Select<String> sortBy = new Select<>();
        sortBy.setLabel("Sort by");
        sortBy.setItems("Popularity", "Newest first", "Oldest first");
        sortBy.setValue("Popularity");

        productImageContainer.addClassNames("gap-l", "grid", "m-0", "p-0");

        container.add(header, sortBy);
        add(container, productImageContainer);

    }

}