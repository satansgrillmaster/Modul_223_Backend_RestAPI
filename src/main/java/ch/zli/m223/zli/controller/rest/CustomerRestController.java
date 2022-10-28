package ch.zli.m223.zli.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.zli.controller.rest.dto.CustomerDto;
import ch.zli.m223.zli.controller.rest.dto.CustomerInputDto;
import ch.zli.m223.zli.controller.rest.dto.MemoInputDto;
import ch.zli.m223.zli.model.Customer;
import ch.zli.m223.zli.service.CustomerService;

/**
 * This is the rest-controller for customers
 */
@RestController
@RequestMapping("/api/v0/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    //Get a list of all customers
    @GetMapping("")
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return customers.stream()
                //.skip(n) #to skip as many users we want
                //.filter() #to filter something
                .map((Customer customer) -> {
                    return new CustomerDto(customer);
                }).collect(Collectors.toList());
    }

    //get every information of one customer (by id)
    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable("id") long id) {
        return new CustomerDto(customerService.getCustomerById(id));
    }

    //add an new customer with a post
    @PostMapping("")
    public CustomerDto addCustomer(@RequestBody CustomerInputDto customer) {
        return new CustomerDto(customerService.addCustomer(customer.name, customer.street, customer.city));
    }

    //delete an customer by his id
    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") long id) {
        customerService.deleteById(id);
    }

    //add an new memo to an customer
    @PostMapping("/{id}/memos")
    public CustomerDto addMemo(@PathVariable("id") long id, @RequestBody MemoInputDto memos) {

        return new CustomerDto(customerService.setMemosForCustomer(id, memos.memo));
    }

    @DeleteMapping("/{id}/memos")
    public void deleteRole(@PathVariable("id") long id) {

    }
}