package br.com.pdi.springcore.service.impl;


import br.com.pdi.springcore.domain.Address;
import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {


    private AddressServiceImpl addressService;

    private Map<Long, Customer> customerMap;

    @Autowired
    public CustomerServiceImpl(AddressServiceImpl addressService){
        this.addressService = addressService;
        loadCustomer();
    }

    private void loadCustomer(){
        customerMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Maria");
        customer1.setLastName("Pedroso");
        customer1.setEmail("mp@email.com");
        customer1.setPhoneNumber("9999-9999");

        List<Address> addressList1 = new ArrayList<>();

        addressList1.add(addressService.getAddressById(1L));
        addressList1.add(addressService.getAddressById(2L));

        customer1.setAddressList(addressList1);

        customerMap.put(1L, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Cintia");
        customer2.setLastName("Neves");
        customer2.setEmail("cn@email.com");
        customer2.setPhoneNumber("0000-0000");

        List<Address> addressList2 = new ArrayList<>();

        addressList2.add(addressService.getAddressById(3L));
        addressList2.add(addressService.getAddressById(4L));

        customer2.setAddressList(addressList2);

        customerMap.put(2L, customer2);
    }

    public CustomerServiceImpl(){
        loadCustomer();
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        if(customer != null){
            if(customer.getId() == null){
                customer.setId(getNextKey());
            }
            customerMap.put(customer.getId(), customer);
            return customer;
        }else{
            throw new RuntimeException("Customer can't be nill");
        }
    }

    private Long getNextKey() {
        return Collections.max(customerMap.keySet()) + 1L;
    }

    @Override
    public List<Customer> listAllCustomer() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerMap.get(id);
    }
}
