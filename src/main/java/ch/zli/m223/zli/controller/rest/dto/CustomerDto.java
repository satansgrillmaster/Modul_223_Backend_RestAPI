package ch.zli.m223.zli.controller.rest.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.zli.model.Customer;
import ch.zli.m223.zli.model.Memo;

/**
 * This is an DTO to render the information we want to show of a customer
 */
public class CustomerDto {
    public long id;
    public String name;
    public String street;
    public String city;
    public List<Memo> memos = new ArrayList<>();

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.street = customer.getStreet();
        this.city = customer.getCity();
        memos.addAll(customer.getMemos());
    }
}