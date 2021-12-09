package gr.codehub.advcart.repository;

import gr.codehub.advcart.model.Customer;
import gr.codehub.advcart.model.Employee;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class EmployeeRepository implements Repository<Employee, Long>{

    private EntityManager entityManager;


    @Override
    public Optional<Employee> save(Employee employee) {

        if (employee ==null) return Optional.empty();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        return employee.getId()==0? Optional.empty(): Optional.of(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.of(entityManager.find(Employee.class, id));
    }

    @Override
    public List<Employee> findAll() {
        return  entityManager.createQuery("Select c from Employee c").getResultList();
    }


    @Override
    public boolean deleteById(Long id) {

        Employee persistentInstance = entityManager.find(Employee.class, id);
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
