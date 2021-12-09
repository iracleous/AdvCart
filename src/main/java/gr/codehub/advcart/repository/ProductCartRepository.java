package gr.codehub.advcart.repository;


import gr.codehub.advcart.model.ProductCart;
import gr.codehub.advcart.model.ProductCart;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductCartRepository implements Repository<ProductCart, Long>{

    private EntityManager entityManager;


    @Override
    public Optional<ProductCart> save(ProductCart productCart) {

        if (productCart ==null) return Optional.empty();
        entityManager.getTransaction().begin();
        entityManager.persist(productCart);
        entityManager.getTransaction().commit();

        return productCart.getId()==0? Optional.empty(): Optional.of(productCart);
    }

    @Override
    public Optional<ProductCart> findById(Long id) {
        return Optional.of(entityManager.find(ProductCart.class, id));
    }

    @Override
    public List<ProductCart> findAll() {
        return  entityManager.createQuery("Select c from ProductCart c").getResultList();
    }


    @Override
    public boolean deleteById(Long id) {

        ProductCart persistentInstance = entityManager.find(ProductCart.class, id);
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
