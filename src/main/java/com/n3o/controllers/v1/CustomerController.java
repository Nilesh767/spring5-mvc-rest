package com.n3o.controllers.v1;

import com.n3o.api.v1.model.CategoryDTO;
import com.n3o.api.v1.model.CategoryListDTO;
import com.n3o.api.v1.model.CustomerDTO;
import com.n3o.api.v1.model.CustomerListDTO;
import com.n3o.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getListOfCustomers(){
        return new ResponseEntity<>(
                new CustomerListDTO(customerService.getAllCustomers())
                ,HttpStatus.OK);
    }
    @GetMapping({"{id}"})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(
                customerService.getCustomerById(id),HttpStatus.OK);
    }

}
