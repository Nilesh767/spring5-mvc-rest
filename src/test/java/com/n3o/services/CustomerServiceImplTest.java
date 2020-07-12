package com.n3o.services;

import com.n3o.api.v1.mapper.CustomerMapper;
import com.n3o.api.v1.model.CustomerDTO;
import com.n3o.domain.Customer;
import com.n3o.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    CustomerService customerService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerMapper, customerRepository);
    }

    @Test
    public void getAllCustomers() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Michale");
        customer1.setLastname("Weston");

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Sam");
        customer2.setLastname("Axe");

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(2, customerDTOS.size());

    }

    @Test
    public void getCustomerById() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Michale");
        customer1.setLastname("Weston");

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer1));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals("Michale", customerDTO.getFirstname());
    }

}