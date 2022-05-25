package spring.website.supermarket.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import spring.website.supermarket.data.entity.Product;
import spring.website.supermarket.data.service.SupermarketService;
import spring.website.supermarket.views.SupermarketComponents.BasketViewList;
import spring.website.supermarket.views.SupermarketComponents.CategoryTabsList;
import spring.website.supermarket.views.SupermarketComponents.SupermarketMainLayout;

import javax.annotation.security.PermitAll;
import java.util.List;

@Route(value = "/supermarket", layout = SupermarketMainLayout.class)
@PageTitle("Supermarket")
@PermitAll
public class SupermarketView extends Div {

    private SupermarketService service;
    private List<Product> addedProducts;

    public List<Product> getAddedProducts() {
        return addedProducts;
    }
    public void setAddedProducts(List<Product> addedProducts) {
        this.addedProducts = addedProducts;
    }

    CategoryTabsList mainTabs;
    BasketViewList basket;

    public SupermarketView(SupermarketService service) {
        this.service = service;
        addClassName("list-view");
        setSizeFull();

        mainTabs = new CategoryTabsList(service.findAllProducts(null), service.getAllCategories());
        basket = new BasketViewList(service.findAllProducts(null));
        basket.setWidth("20em");

        FlexLayout mainContent = new FlexLayout(mainTabs, basket);
        mainContent.setFlexGrow(10, mainTabs);
        mainContent.setFlexGrow(1, basket);
        mainContent.addClassNames("content", "gap-m");
        mainContent.setSizeFull();



        add(mainContent);
    }
}

