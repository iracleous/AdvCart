package gr.codehub.advcart.repository;

import gr.codehub.advcart.model.Product;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductRepository implements  Repository<Product, Long>{
    private EntityManager entityManager;


    @Override
    public Optional<Product> save(Product product) {

        if (product ==null) return Optional.empty();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        return product.getId()==0? Optional.empty(): Optional.of(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = entityManager.find(Product.class, id);
        return  product==null?Optional.empty():Optional.of(product);
    }

    @Override
    public List<Product> findAll() {
        return  entityManager.createQuery("Select c from Product c").getResultList();
    }


    @Override
    public boolean deleteById(Long id) {

        Product persistentInstance = entityManager.find(Product.class, id);
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



    public Optional<Product> findByName(String productName){
        List<Product> products =   entityManager
                .createQuery("Select P from Product P where P.name =:productName")
                .setParameter("productName",productName)
                .getResultList();

         return  Optional.of(products.get(0));
    }



}
