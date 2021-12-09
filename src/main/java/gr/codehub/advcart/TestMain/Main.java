package gr.codehub.advcart.TestMain;

import gr.codehub.advcart.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setName("Stamos");

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();




        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();




        entityManager.close();
        entityManagerFactory.close();

        System.out.println(customer.getId());
    }
}
