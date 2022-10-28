package ch.zli.m223.zli.service;

import java.util.List;
import java.util.Optional;

import ch.zli.m223.zli.model.Customer;
import ch.zli.m223.zli.model.impl.CustomerImpl;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(long id);

    void deleteById(long id);

    Optional<CustomerImpl> getCustomerByName(String name);

    Customer addCustomer(String name, String street, String city);

    Customer setMemosForCustomer(long id, String memos);
}