package br.com.pdi.springcore.service.impl;


import br.com.pdi.springcore.domain.Address;
import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.domain.DomainObject;
import br.com.pdi.springcore.service.AbstractMapService;
import br.com.pdi.springcore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }


    @Override
    public Customer getById(Long id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }


    @Override
    protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Maria");
        customer1.setLastName("Pedroso");
        customer1.setEmail("mp@email.com");
        customer1.setPhoneNumber("9999-9999");

        domainMap.put(1L, (DomainObject) customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Cintia");
        customer2.setLastName("Neves");
        customer2.setEmail("cn@email.com");
        customer2.setPhoneNumber("0000-0000");

        domainMap.put(2L, (DomainObject) customer2);
    }
}
