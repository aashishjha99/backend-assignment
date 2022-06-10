package com.product.productlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.productlist.model.ShippingDetails;
import com.product.productlist.repository.ShippingDetRepo;

@Service
public class ShippingDetailsSrvc {

    @Autowired
    private ShippingDetRepo shippingDetRepo;

    public ShippingDetails saveShippingDetails(ShippingDetails shippingDetails) {
        return shippingDetRepo.save(shippingDetails);
    }


    public ShippingDetails getShippingDetails(long custID,long PurcID)
    {
        return shippingDetRepo.getShippingDetails(custID, PurcID);
    }
}
