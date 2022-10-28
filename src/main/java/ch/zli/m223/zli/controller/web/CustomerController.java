package ch.zli.m223.crm.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.zli.m223.zli.model.Customer;
import ch.zli.m223.zli.service.CustomerService;

/**
 * Das ist der Webcontroller für den Customer
 */
@Controller
@RequestMapping("/web/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * Is to get and see all customers
     *
     * @param model black magic of spring
     * @return to the template customerList.html
     */
    @GetMapping("/customer_list")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customerList";
    }

    /**
     * Is to see one customer (single-view)
     *
     * @param id    of the customer
     * @param model black magic of spring
     * @return to the template customer.html
     */
    @GetMapping("/{id}")
    public String getOneCustomerById(@PathVariable("id") long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer";
    }

    /**
     * Is to delete a customer
     *
     * @param id    of the customer
     * @param model black magic of spring
     * @return lets the function getAllCustomers(Model model) run
     */
    @GetMapping("/admin/{id}/delete")
    public String deleteCustomer(@PathVariable("id") long id, Model model) {
        customerService.deleteById(id);
        return getAllCustomers(model);
    }

    /**
     * shows the form to add an customer
     *
     * @return the view addCustomerForm
     */
    @GetMapping("/admin/addcustomerform")
    public String addAnCustomerForm() {
        return "addCustomerForm";
    }

    /**
     * adds a new customer and shows all again
     *
     * @param model  black magic of spring
     * @param name   of the customer
     * @param street of the customer
     * @param city   of the customer
     * @param memo   from the customer
     * @return the new view of all customers (bug with memo)
     */
    @PostMapping("/admin/addcustomer")
    public String addAnUser(Model model, @RequestParam String name, @RequestParam String street,
                            @RequestParam String city, @RequestParam String memo) {
        Customer customer = customerService.addCustomer(name, street, city);
        customerService.setMemosForCustomer(customer.getId(), memo);
        return getAllCustomers(model);
    }
}