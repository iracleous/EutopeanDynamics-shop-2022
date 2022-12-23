/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.europeanwebshop.dto;

import gr.codehub.europeanwebshop.model.Customer;

/**
 *
 * @author iracl
 */
public class CustomerDto {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
       public CustomerDto(){
        
    }
    public CustomerDto(Customer customer){
        this.id =customer.getId();
        this.name=customer.getName();
    }
    
    public Customer asCustomer(){
        Customer customer =new Customer();
        customer.setId(id);
        customer.setName(name);
        return customer;
    }
}
