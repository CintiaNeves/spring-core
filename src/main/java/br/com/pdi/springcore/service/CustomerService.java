package br.com.pdi.springcore.service;

import br.com.pdi.springcore.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer saveOrUpdate(Customer customer);

    List<Customer> listAllCustomer();

    Customer getCustomerById(Long id);

    void deleteProduct(Long id);
}
