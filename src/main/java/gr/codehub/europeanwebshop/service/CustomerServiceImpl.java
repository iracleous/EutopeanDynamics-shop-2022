/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.europeanwebshop.service;

import gr.codehub.europeanwebshop.dto.CustomerDto;
import gr.codehub.europeanwebshop.exception.CustomerException;
import gr.codehub.europeanwebshop.model.Customer;
import gr.codehub.europeanwebshop.repository.CustomerRepository;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iracl
 */
public class CustomerServiceImpl implements CustomerService{
    
    @Inject
    private CustomerRepository customerRepository;
    
    @Override
    public List<CustomerDto> geCustomers() {
       return customerRepository.findAll()
               .stream()
               .map(customer -> new CustomerDto(customer))
               .toList();
    }

    @Override
    public CustomerDto getCustomer(long customerId) throws CustomerException{
            return new CustomerDto(customerRepository.findById(customerId));
    }

    @Override
    public void createCustomer(CustomerDto customer)  throws CustomerException {
            customerRepository.createCustomer(customer.asCustomer());
    }
    
     @Override
    public  boolean deleteCustomer(long customerId){
        return customerRepository.deleteCustomer(customerId);
    }
}
