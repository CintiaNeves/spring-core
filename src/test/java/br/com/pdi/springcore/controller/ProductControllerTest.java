package br.com.pdi.springcore.controller;

import br.com.pdi.springcore.domain.Product;
import br.com.pdi.springcore.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@Controller
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.
            standaloneSetup(productController)
            .build();
    }

    @Test
    public void testList()throws Exception{
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        when(productService.listAll())
            .thenReturn((List) products);

        mockMvc.perform(get("/product/list"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/list"))
            .andExpect(model().attribute("products", hasSize(2)));
    }

    @Test
    public void testShow() throws Exception{
        Long id = 1L;

        when(productService.getById(id))
            .thenReturn(new Product());

        mockMvc.perform(get("/product/show/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/show"))
            .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void testEdit() throws Exception{
        Long id = 1L;

        when(productService.getById(id))
            .thenReturn(new Product());

        mockMvc.perform(get("/product/edit/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/productForm"))
            .andExpect(model().attribute("product", instanceOf(Product.class)));
}

    @Test
    public void newProduct() throws Exception{
        Long id = 1L;

        verifyNoMoreInteractions(productService);

        mockMvc.perform(get("/product/new"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/productForm"))
            .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void saveOrUpdate() throws Exception{
        Long id = 1L;
        String description = "Test description";
        BigDecimal price = new BigDecimal(25.5);
        String imageUrl = "example.com";


        verifyNoMoreInteractions(productService);

        mockMvc.perform(get("/product/new"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/productForm"))
            .andExpect(model().attribute("product", instanceOf(Product.class)));

        Product returnProduct = new Product();
        returnProduct.setId(id);
        returnProduct.setDescription(description);
        returnProduct.setPrice(price);
        returnProduct.setImageUrl(imageUrl);

        when(productService.saveOrUpdate((Product) Matchers.<Product>any(Product.class)))
            .thenReturn(returnProduct);

        mockMvc.perform(post("/product")
            .param("id", "1")
            .param("description", description)
            .param("price", "25.5")
            .param("imageUrl", imageUrl))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/show/1"))
                .andExpect(model().attribute("product", instanceOf(Product.class)))
                .andExpect(model().attribute("product", hasProperty("id", is(id))))
                .andExpect(model().attribute("product", hasProperty("description", is(description))))
                .andExpect(model().attribute("product", hasProperty("price", is(price))))
                .andExpect(model().attribute("product", hasProperty("imageUrl", is(imageUrl))));

        ArgumentCaptor<Product> boundProduct = ArgumentCaptor.forClass(Product.class);
        verify(productService).saveOrUpdate(boundProduct.capture());

        assertEquals(id, boundProduct.getValue().getId());
        assertEquals(description, boundProduct.getValue().getDescription());
        assertEquals(price, boundProduct.getValue().getPrice());
        assertEquals(imageUrl, boundProduct.getValue().getImageUrl());

    }

    @Test
    public void testDelete() throws Exception{
        Long id = 1L;

        mockMvc.perform(get("/product/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/list"));

        verify(productService, times(1)).delete(id);
    }
}
