package spring.website.supermarket.data.entity;

import com.vaadin.flow.server.StreamResource;

import javax.persistence.*;
import java.io.ByteArrayInputStream;

@Entity
public class Product {

    @Id
    @Column(nullable = false, length = 5)
    private String product_id;

    @Column(nullable = false, length = 30)
    private String product_name;

    @Column(nullable = false)
    private String product_desc;

    @Column(nullable = false)
    private String product_price;

    @Column(nullable = false, length = 30)
    private String product_category;

    @Column()
    private byte[] product_photo;

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public byte[] getByteProduct_photo() {
        return product_photo;
    }
    public StreamResource getProduct_photo(String product_id) {
        return new StreamResource(product_id, () -> new ByteArrayInputStream(product_photo));
    }

    public void setProduct_photo(byte[] photos) {
        this.product_photo = photos;
    }
}
