package br.com.pdi.springcore.services;

import br.com.pdi.springcore.config.JpaIntegrationConfig;
import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.domain.User;
import br.com.pdi.springcore.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ActiveProfiles("jpadao")
@ContextConfiguration(classes = {JpaIntegrationConfig.class})
public class CustomerServiceJpaDaoImplTest {

    private CustomerService customerService;

    @Autowired
    public void setProductService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void testListMethod()throws Exception{
        List<Customer> customers = (List<Customer>) customerService.listAll();
        assert customers.size() == 2;

    }

    @Test
    public void testSaveWithUser(){
        Customer customer = new Customer();
        User user = new User();
        customer.setUser(user);

        Customer savedCustomer = customerService.saveOrUpdate(customer);

        assert savedCustomer.getId() != null;
        assert savedCustomer.getUser().getId() != null;
    }
}
