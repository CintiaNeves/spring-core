package br.com.pdi.springcore.services;

import br.com.pdi.springcore.config.JpaIntegrationConfig;
import br.com.pdi.springcore.domain.Product;
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
public class ProductServiceJpaDaoImplTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testListMethod()throws Exception{
        List<Product> products = (List<Product>) productService.listAll();
        assert products.size() == 5;

    }
}
