package br.com.pdi.springcore.bootstrap;

import br.com.pdi.springcore.domain.Address;
import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.domain.Product;
import br.com.pdi.springcore.domain.User;
import br.com.pdi.springcore.service.AddressService;
import br.com.pdi.springcore.service.CustomerService;
import br.com.pdi.springcore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private AddressService addressService;
    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadCustomers();
    }

    private void loadProducts(){
        Product product1 = new Product();
        product1.setId(1L);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setId(3L);
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setId(4L);
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setId(5L);
        product5.setDescription("Product 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        productService.saveOrUpdate(product5);

    }

    private void loadCustomers(){
        Customer customer1 = new Customer();
        User user1 = new User();
        user1.setUsername("myUsername1");
        user1.setPassword("myPassword1");
        customer1.setId(1L);
        customer1.setFirstName("Maria");
        customer1.setLastName("Pedroso");
        customer1.setEmail("mp@email.com");
        customer1.setPhoneNumber("9999-9999");
        customer1.setUser(user1);

        customerService.saveOrUpdate(customer1);

        Customer customer2 = new Customer();
        User user2 = new User();
        user2.setUsername("myUsername2");
        user2.setPassword("myPassword2");
        customer2.setId(2L);
        customer2.setFirstName("Cintia");
        customer2.setLastName("Neves");
        customer2.setEmail("cn@email.com");
        customer2.setPhoneNumber("0000-0000");
        customer2.setUser(user2);

        customerService.saveOrUpdate(customer2);
    }
}
