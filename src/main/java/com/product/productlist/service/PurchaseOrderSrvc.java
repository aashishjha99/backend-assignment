package com.product.productlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.productlist.model.PurchaseOrder;
import com.product.productlist.repository.PurchOrderRepo;

@Service
public class PurchaseOrderSrvc {
    

    @Autowired
    private PurchOrderRepo purchOrderRepo;

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {


        return purchOrderRepo.save(purchaseOrder);
    }

    public PurchaseOrder getPurchaseOrderid(long id){

        return purchOrderRepo.getPurchaseOrderid(id);
    }

    public PurchaseOrder getPurchaseDetails(long id){
        return purchOrderRepo.getAllPurchaseDetails(id);
    }
}
