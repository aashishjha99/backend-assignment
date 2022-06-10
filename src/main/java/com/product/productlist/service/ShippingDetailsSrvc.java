package com.product.productlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.productlist.model.ShippingDetails;
import com.product.productlist.repository.ShippingDetRepo;
import java.util.List;
@Service
public class ShippingDetailsSrvc {

    @Autowired
    private ShippingDetRepo shippingDetRepo;

    public ShippingDetails saveShippingDetails(ShippingDetails shippingDetails) {
        return shippingDetRepo.save(shippingDetails);
    }


    public List<ShippingDetails> getShippingDetails(long custID,long PurcID)
    {
        var shipping = (List<ShippingDetails>)shippingDetRepo.getShippingDetails(custID, PurcID);
        return shipping;
    }
}
