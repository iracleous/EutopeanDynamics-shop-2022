/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.europeanwebshop.repository;

import gr.codehub.europeanwebshop.exception.CustomerException;
import gr.codehub.europeanwebshop.model.Customer;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface CustomerRepository {
    List<Customer> findAll(String name);
    void createCustomer(Customer customer) throws CustomerException;
    Customer findById(long customerId)  throws CustomerException;
    boolean deleteCustomer(long customerId)  ;
}
