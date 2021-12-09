package gr.codehub.advcart.repository;

import gr.codehub.advcart.model.Customer;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class CustomerRepository implements Repository<Customer, Long>{

    private EntityManager entityManager;


    @Override
    public Optional<Customer> save(Customer customer) {

        if (customer ==null) return Optional.empty();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        return customer.getId()==0? Optional.empty(): Optional.of(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.of(entityManager.find(Customer.class, id));
    }

    @Override
    public List<Customer> findAll() {
        return  entityManager.createQuery("Select c from Customer c").getResultList();
    }


    @Override
    public boolean deleteById(Long id) {

        Customer persistentInstance = entityManager.find(Customer.class, id);
        if (persistentInstance != null) {

            try {
                entityManager.getTransaction().begin();
                entityManager.remove(persistentInstance);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                //e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }
}
