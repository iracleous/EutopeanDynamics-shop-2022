/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.europeanwebshop.repository;

import gr.codehub.europeanwebshop.exception.CustomerException;
import gr.codehub.europeanwebshop.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iracl
 */
public class CustomerRepositoryImpl implements CustomerRepository{

    @PersistenceContext (unitName="Persistence")
    private EntityManager entityManager;
    
    
    @Override
    public List<Customer> findAll() {
        
        return entityManager.createQuery("select c from Customer c").getResultList();    
    }

    @Override
   @Transactional
    public void createCustomer(Customer customer) throws CustomerException {
            entityManager.persist(customer);
    }

    @Override
    @Transactional
    public Customer findById(long customerId)  throws CustomerException{
        Customer customer =  entityManager.find(Customer.class, customerId);
        if (customer==null) throw new CustomerException("customer not found");
        return customer;
    }

    @Override
     @Transactional   
    public boolean deleteCustomer(long customerId)    {
        Customer customer =  entityManager.find(Customer.class, customerId);
        if (customer==null) return false;
        entityManager.remove(customer);
        return true;
    }
    
}
