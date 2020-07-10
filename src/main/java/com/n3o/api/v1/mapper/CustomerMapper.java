package com.n3o.api.v1.mapper;

import com.n3o.api.v1.model.CustomerDTO;
import com.n3o.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO CustomerToCustomerDTO(Customer customer);
}
