package br.com.pdi.springcore.controller;

import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.service.CustomerService;
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
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.
            standaloneSetup(customerController)
            .build();
    }

    @Test
    public void testList()throws Exception{
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());

        when(customerService.listAll())
            .thenReturn((List) customers);

        mockMvc.perform(get("/customer/list"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/list"))
            .andExpect(model().attribute("customers", hasSize(2)));
    }

    @Test
    public void testShow() throws Exception{
        Long id = 1L;

        when(customerService.getById(id))
            .thenReturn(new Customer());

        mockMvc.perform(get("/customer/show/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/show"))
            .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testEdit() throws Exception{
        Long id = 1L;

        when(customerService.getById(id))
            .thenReturn(new Customer());

        mockMvc.perform(get("/customer/edit/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/customerForm"))
            .andExpect(model().attribute("customer", instanceOf(Customer.class)));
}

    @Test
    public void newCustomer() throws Exception{
        Long id = 1L;

        verifyNoMoreInteractions(customerService);

        mockMvc.perform(get("/customer/new"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/customerForm"))
            .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void saveOrUpdate() throws Exception{
        Long id = 1L;
        String firstName = "firstName";
        String lastName = "lastName";
        String email = "email.com";
        String phoneNumber = "99999999";



        verifyNoMoreInteractions(customerService);

        mockMvc.perform(get("/customer/new"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/customerForm"))
            .andExpect(model().attribute("customer", instanceOf(Customer.class)));

        Customer returnCustomer = new Customer();
        returnCustomer.setId(id);
        returnCustomer.setFirstName(firstName);
        returnCustomer.setLastName(lastName);
        returnCustomer.setEmail(email);
        returnCustomer.setPhoneNumber(phoneNumber);

        when(customerService.saveOrUpdate((Customer) Matchers.<Customer>any(Customer.class)))
            .thenReturn(returnCustomer);

        mockMvc.perform(post("/customer")
            .param("id", "1")
            .param("firstName", firstName)
            .param("lastName", lastName)
            .param("email", email)
            .param("phoneNumber", phoneNumber))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/show/1"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                .andExpect(model().attribute("customer", hasProperty("id", is(id))))
                .andExpect(model().attribute("customer", hasProperty("firstName", is(firstName))))
                .andExpect(model().attribute("customer", hasProperty("lastName", is(lastName))))
                .andExpect(model().attribute("customer", hasProperty("email", is(email))))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is(phoneNumber))));

        ArgumentCaptor<Customer> boundCustomer = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).saveOrUpdate(boundCustomer.capture());

        assertEquals(id, boundCustomer.getValue().getId());
        assertEquals(firstName, boundCustomer.getValue().getFirstName());
        assertEquals(lastName, boundCustomer.getValue().getLastName());
        assertEquals(email, boundCustomer.getValue().getEmail());
        assertEquals(phoneNumber, boundCustomer.getValue().getPhoneNumber());

    }

    @Test
    public void testDelete() throws Exception{
        Long id = 1L;

        mockMvc.perform(get("/customer/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/list"));

        verify(customerService, times(1)).delete(id);
    }
}
