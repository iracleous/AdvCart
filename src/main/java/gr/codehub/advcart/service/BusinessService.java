package gr.codehub.advcart.service;

import gr.codehub.advcart.model.Cart;
import gr.codehub.advcart.model.Customer;
import gr.codehub.advcart.model.Product;
import gr.codehub.advcart.model.ProductCart;
import gr.codehub.advcart.repository.CartRepository;
import gr.codehub.advcart.repository.CustomerRepository;
import gr.codehub.advcart.repository.ProductCartRepository;
import gr.codehub.advcart.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class BusinessService {

    private EntityManager entityManager;

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private ProductCartRepository productCartRepository;

    public BusinessService(EntityManager entityManager) {
        customerRepository = new CustomerRepository(entityManager);
        productRepository = new ProductRepository(entityManager);
        cartRepository = new CartRepository(entityManager);
        productCartRepository = new ProductCartRepository(entityManager);
    }

    public void setUpData() {
        Customer customer = new Customer();
        customer.setName("Stamos");
        customerRepository.save(customer);
        {
            Product product = new Product();
            product.setName("chips");
            product.setPrice(1.20);
            productRepository.save(product);
        }
        {
            Product product = new Product();
            product.setName("chocolate");
            product.setPrice(1.80);
            productRepository.save(product);
        }
        {
            Product product = new Product();
            product.setName("wafers");
            product.setPrice(0.90);
            productRepository.save(product);
        }
    }

    public long cart(long customerId, long[] productIds) {

        Customer customer = customerRepository.findById(customerId).get();


        Cart cart = new Cart();
        cart.setDate(LocalDate.now());
        cart.setCustomer(customer);

        cartRepository.save(cart);

        for (Long productId : productIds) {
            Product product = productRepository.findById(productId).get();

            ProductCart productCart = new ProductCart();
            productCart.setCart(cart);
            productCart.setProduct(product);
            productCart.setQuantity(2);
            productCart.setDiscount(0.1);
            productCartRepository.save(productCart);

        }

        return cart.getId();
    }

}
