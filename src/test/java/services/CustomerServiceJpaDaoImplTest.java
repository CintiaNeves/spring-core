package services;

import br.com.pdi.springcore.config.JpaIntegrationConfig;
import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.domain.Product;
import br.com.pdi.springcore.service.CustomerService;
import br.com.pdi.springcore.service.ProductService;
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
}
