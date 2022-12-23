/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.europeanwebshop.service;

import gr.codehub.europeanwebshop.dto.CustomerDto;
import gr.codehub.europeanwebshop.dto.RestApiResult;
import gr.codehub.europeanwebshop.exception.CustomerException;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface CustomerService {
        
    List<CustomerDto> geCustomers(String name);

    /**
     *  Info from interface
     * @param customerId
     * @return
     */
    RestApiResult<CustomerDto> getCustomer(long customerId);
    public void createCustomer(CustomerDto customer)  throws CustomerException;
    boolean deleteCustomer(long customerId);
}
