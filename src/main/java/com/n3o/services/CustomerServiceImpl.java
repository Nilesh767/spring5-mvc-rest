package com.n3o.services;

import com.n3o.api.v1.mapper.CustomerMapper;
import com.n3o.api.v1.model.CustomerDTO;
import com.n3o.domain.Customer;
import com.n3o.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerMapper customerMapper;
    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.CustomerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("api/v1/customer/"+customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
    return customerRepository.findById(id)
            .map(customerMapper :: CustomerToCustomerDTO)
            .orElseThrow(RuntimeException::new);//todo implement better exception handling
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnDto.setCustomerUrl("/api/v1/customer/" + savedCustomer.getId());
        return returnDto;
    }
}
