package gr.codehub.advcart.repository;

import gr.codehub.advcart.model.Cart;
import gr.codehub.advcart.model.Customer;
import gr.codehub.advcart.model.Employee;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CartRepository implements Repository<Cart, Long>{

    private EntityManager entityManager;


    @Override
    public Optional<Cart> save(Cart cart) {

        if (cart ==null) return Optional.empty();
        entityManager.getTransaction().begin();
        entityManager.persist(cart);
        entityManager.getTransaction().commit();

        return cart.getId()==0? Optional.empty(): Optional.of(cart);
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return Optional.of(entityManager.find(Cart.class, id));
    }

    @Override
    public List<Cart> findAll() {
        return  entityManager.createQuery("Select c from Cart c").getResultList();
    }


    @Override
    public boolean deleteById(Long id) {

        Cart persistentInstance = entityManager.find(Cart.class, id);
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
