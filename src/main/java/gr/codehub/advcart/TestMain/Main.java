package gr.codehub.advcart.TestMain;

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
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        //objects from GUI
        Customer customer = new Customer();
        customer.setName("Stamos");

        Product product = new Product();
        product.setName("chips");
        product.setPrice(1.20);


        //
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Persistence");
   //     EntityManager entityManager = entityManagerFactory.createEntityManager();

        CustomerRepository customerRepository = new CustomerRepository(entityManagerFactory.createEntityManager());
        ProductRepository productRepository = new ProductRepository(entityManagerFactory.createEntityManager());
        CartRepository cartRepository = new CartRepository(entityManagerFactory.createEntityManager());
        ProductCartRepository productCartRepository = new ProductCartRepository(entityManagerFactory.createEntityManager());

        customerRepository.save(customer);
        productRepository.save(product);


        Optional<Product> anotherProduct = productRepository.findById(product.getId());


        Cart cart = new Cart();
        cart.setDate(LocalDate.now());
        cart.setCustomer(customer);

        cartRepository.save(cart);


        ProductCart productCart = new ProductCart();
        productCart.setCart(cart);
        productCart.setProduct(product);
        productCart.setQuantity(2);
        productCart.setDiscount(0.1);

        productCartRepository.save(productCart);



        entityManagerFactory.close();

        System.out.println(customer.getId());
    }
}
