package com.product.productlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.productlist.model.Customer;
import com.product.productlist.repository.CutomerRepo;

@Service
public class CustomerSrvc {


    @Autowired
    private CutomerRepo cutomerRepo;


    public Customer saveCustDetails(Customer customer) {

        return cutomerRepo.save(customer);
    }

    public Customer getCustomerDetails(String email) {

        return cutomerRepo.findbymail(email);
    }
    
}
