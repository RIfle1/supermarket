package spring.website.supermarket.views.SupermarketComponents;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import spring.website.supermarket.data.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryTabsList extends Div {

    public VerticalLayout mainLayout = new VerticalLayout();
    public VerticalLayout content = new VerticalLayout();
    public Tabs tabs = new Tabs();

    public CategoryTabsList(List<Product> allProducts, List<String> categories) {


        tabs.addClassNames("pt-m");

        categories.forEach(category -> {tabs.add(new Tab(category));});

        tabs.addSelectedChangeListener(event ->
                setContent(event.getSelectedTab().getLabel(), allProducts)
        );

        content.setSpacing(false);
        content.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        content.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        content.addClassNames("bg-contrast-20", "rounded-l", "block");
        setContent(tabs.getSelectedTab().getLabel(), allProducts);

        mainLayout.add(tabs, content);
        mainLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        mainLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        add(mainLayout);
    }

    private void setContent(String category, List<Product> allProducts) {
        content.removeAll();

        List<Product> sortedByCategoryProducts = allProducts.stream()
                        .filter(product -> product.getProduct_category().matches(category))
                .collect(Collectors.toList());

        content.add(new ProductImageView(category, sortedByCategoryProducts));
    }
}
