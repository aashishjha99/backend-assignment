package com.product.productlist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.productlist.model.Customer;
import com.product.productlist.model.PurchaseOrder;
import com.product.productlist.model.ShippingDetails;
import com.product.productlist.repository.CutomerRepo;
import com.product.productlist.service.CustomerSrvc;
import com.product.productlist.service.PurchaseOrderSrvc;
import com.product.productlist.service.ShippingDetailsSrvc;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class AuthController {

    @Autowired
    private CustomerSrvc customerSrvc;

    @Autowired
    private PurchaseOrderSrvc purchaseOrderSrvc;

    @Autowired
    private ShippingDetailsSrvc shippingDetailsSrvc;

    @Autowired
    private CutomerRepo cutomerRepo;

    @PostMapping("/Customer")
    public ResponseEntity<String> insertCustomer(@RequestBody Customer customer) {

        Customer customer2 = customerSrvc.getCustomerDetails(customer.getEmail());

        if (customer2 == null) {
            Customer customer3 = customerSrvc.saveCustDetails(customer);

            if (customer3 != null) {

                return new ResponseEntity<String>("Customer Added", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Not Added", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<String>("customer vailable with same email id", HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping("/Purchase")
    public ResponseEntity<String> insertPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        Customer customer = customerSrvc.getCustomerDetails(purchaseOrder.getCustomer().getEmail());

        if (customer != null) {

            purchaseOrder.setCustomer(customer);
            PurchaseOrder purchaseOrder2 = purchaseOrderSrvc.savePurchaseOrder(purchaseOrder);

            if (purchaseOrder2 != null) {

                return new ResponseEntity<String>("order placed", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("couldnt place order", HttpStatus.BAD_REQUEST);
            }

        } else {

            return new ResponseEntity<String>("customer not available", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/Shipping")
    public ResponseEntity<String> insertShippingDetails(@RequestBody ShippingDetails shippingDetails) {
        Customer customer = customerSrvc.getCustomerDetails(shippingDetails.getCustomer().getEmail());
        PurchaseOrder purchaseOr = purchaseOrderSrvc.getPurchaseOrderid(customer.getCustomerId());

        System.out.println("sssssss" + " " + purchaseOr);

        if (customer != null && purchaseOr != null) {

            shippingDetails.setCustomer(customer);
            shippingDetails.setPurchaseOrder(purchaseOr);
            ShippingDetails shippingDetails2 = shippingDetailsSrvc.saveShippingDetails(shippingDetails);

            if (shippingDetails2 != null) {
                return new ResponseEntity<String>("shipped", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("couldnt shipped", HttpStatus.BAD_REQUEST);
            }

        } else {

            return new ResponseEntity<String>("noting is in order list", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/Customer/{City}")
    public List<Customer> getCustomerByCity(@PathVariable String City) {

        var cities = (List<Customer>) customerSrvc.getCustomerCity(City);
        return cities;

    }

    @GetMapping("/Purchase/Customer/{id}")
    public List<PurchaseOrder> getPurchaseDetails(@PathVariable Long id) {

        var purchase = (List<PurchaseOrder>) purchaseOrderSrvc.getPurchaseDetails(id);
        return purchase;
    }

    @GetMapping("/Purchase/Details/{CustID}/{PurchID}")
    public List<ShippingDetails> getPurchasingDetails(@PathVariable long CustID, @PathVariable long PurchID) {

        var shipping = (List<ShippingDetails>) shippingDetailsSrvc.getShippingDetails(CustID, PurchID);
        return shipping;
    }
}
