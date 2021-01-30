package br.com.pdi.springcore.controller;

import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService){
        this.customerService = customerService;
    }

    @RequestMapping({"/list", "/"})
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAll());
        return "customer/list";
    }

    @RequestMapping("/show/{id}")
    public String showCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerForm";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customerForm";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Customer customer){
        Customer customerSaved = customerService.saveOrUpdate(customer);
        return "redirect:/customer/show/" + customerSaved.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
