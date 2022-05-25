package spring.website.supermarket.data.service;

import org.springframework.stereotype.Service;
import spring.website.supermarket.data.entity.Product;
import spring.website.supermarket.data.entity.Staff;
import spring.website.supermarket.data.entity.User;
import spring.website.supermarket.data.repository.ProductRepository;
import spring.website.supermarket.data.repository.StaffRepository;
import spring.website.supermarket.data.repository.UserRepository;

import java.util.List;

@Service
public class SupermarketService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final StaffRepository staffRepository;


    public SupermarketService(ProductRepository productRepository,
                              UserRepository userRepository,
                              StaffRepository staffRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.staffRepository = staffRepository;
    }

    public List<User> findAllUsers(String inputText) {
        if(inputText == null || inputText.isEmpty()) {
            return userRepository.findAll();
        }
        else {
            return userRepository.searchUser(inputText);
        }
    }

    public long countUsers() {
        return userRepository.count();
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void saveUser(User user) {
        if(user == null) {
            System.err.println("User is null.");
        }
        else {
            userRepository.save(user);
        }
    }

    public List<Staff> findAllStaff(String inputText) {
        if(inputText == null || inputText.isEmpty()) {
            return staffRepository.findAll();
        }
        else {
            return staffRepository.searchStaff(inputText);
        }
    }

    public long countStaff() {
        return staffRepository.count();
    }

    public void deleteStaff(Staff staff) {
        staffRepository.delete(staff);
    }

    public void saveUser(Staff staff) {
        if(staff == null) {
            System.err.println("Staff is null.");
        }
        else {
            staffRepository.save(staff);
        }
    }

    public List<Product> findAllProducts(String inputText) {
        if(inputText == null || inputText.isEmpty()) {
            return productRepository.findAll();
        }
        else {
            return productRepository.searchProduct(inputText);
        }
    }

    public long countProducts() {
        return productRepository.count();
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public void saveProduct(Product product) {
        if(product == null) {
            System.err.println("Product is null.");
        }
        else {
            productRepository.save(product);
        }
    }

    public byte[] getProductImageById(String id) {
        return productRepository.returnImage(id);
    }

    public String getProductNameById(String id) {
        return productRepository.returnProductName(id);
    }

    public String getProductDescById(String id) {
        return productRepository.returnProductDesc(id);
    }

    public double getProductPriceById(String id) {
        return productRepository.returnProductPrice(id);
    }

    public List<String> getAllCategories() {
        return productRepository.returnAllProductCategories();
    }
}
