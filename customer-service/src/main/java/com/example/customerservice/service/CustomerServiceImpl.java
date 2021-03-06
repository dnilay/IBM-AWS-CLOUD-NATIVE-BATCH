package com.example.customerservice.service;

import com.example.customerservice.dao.CustomerRepository;
import com.example.customerservice.model.CustomerModel;
import com.example.customerservice.shared.CustomerRequestModel;
import com.example.customerservice.shared.CustomerResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@EnableTransactionManagement
public class CustomerServiceImpl implements CustomerService{
    private ModelMapper modelMapper;
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public CustomerResponseModel createCustomer(CustomerRequestModel customerDetails) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model=modelMapper.map(customerDetails,CustomerModel.class);
        model.setCustomerId(UUID.randomUUID().toString());
        CustomerModel response=customerRepository.save(model);
        return modelMapper.map(response,CustomerResponseModel.class);
    }

    @Override
    @Transactional
    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }
}
