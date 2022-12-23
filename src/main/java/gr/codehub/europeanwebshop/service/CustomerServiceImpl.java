/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.europeanwebshop.service;

import gr.codehub.europeanwebshop.dto.CustomerDto;
import gr.codehub.europeanwebshop.dto.RestApiResult;
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
public class CustomerServiceImpl implements CustomerService {
    
    
    /**
     * Roles of the services
     * 1. uses the repository
     * 2. authorization control
     * 3. validation
     * 4. apply business rules -> extra function
     * 5. logging
     */
    
    

    @Inject
    private CustomerRepository customerRepository;

    /**
     * finds all customers
     * @param name
     * @return
     */
    @Override
    public List<CustomerDto> geCustomers(String name) {
        return customerRepository.findAll(name)
                .stream()
                .map(customer -> new CustomerDto(customer))
                .toList();
    }

    @Override
    public RestApiResult< CustomerDto> getCustomer(long customerId)  {

        try {
            CustomerDto customer = new CustomerDto(customerRepository.findById(customerId));
            return new RestApiResult<CustomerDto>(customer, 0, "successful");
        } catch (Exception e) {
            return new RestApiResult<CustomerDto>(null, 100, e.getMessage());
        }
    }

    @Override
    public void createCustomer(CustomerDto customer) throws CustomerException {
        customerRepository.createCustomer(customer.asCustomer());
    }

    @Override
    public boolean deleteCustomer(long customerId) {
        return customerRepository.deleteCustomer(customerId);
    }
}
