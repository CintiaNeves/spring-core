package br.com.pdi.springcore.controller;

import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService){
        this.customerService = customerService;
    }

    @RequestMapping("/customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveOrUpdate(Customer customer){
        return "";
    }

    @RequestMapping("/customers")
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAllCustomer());
        return "customers";
    }
}
