package gr.codehub.advcart.TestMain;

import gr.codehub.advcart.model.Cart;
import gr.codehub.advcart.model.Customer;
import gr.codehub.advcart.model.Product;
import gr.codehub.advcart.model.ProductCart;
import gr.codehub.advcart.repository.CartRepository;
import gr.codehub.advcart.repository.CustomerRepository;
import gr.codehub.advcart.repository.ProductCartRepository;
import gr.codehub.advcart.repository.ProductRepository;
import gr.codehub.advcart.service.BusinessService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

       EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Persistence");
       EntityManager entityManager = entityManagerFactory.createEntityManager();

        BusinessService businessService = new BusinessService(entityManager);

        businessService.setUpData();
        long cartId =  businessService.cart(1, new long[]{1L,2L,3L});

        System.out.println("cartId ="+ cartId);
        entityManager.close();
        entityManagerFactory.close();
     }
}
