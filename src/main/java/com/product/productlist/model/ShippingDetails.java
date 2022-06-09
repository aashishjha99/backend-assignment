package com.product.productlist.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "shippingDetails")
public class ShippingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingid;

    @NonNull
    private String address;

    @NonNull
    private String city;

    @NonNull
    private String pincode;

    @OneToOne(cascade = CascadeType.ALL)
    private PurchaseOrder purchaseOrder;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public ShippingDetails() {

    }

    public ShippingDetails(Long shippingid, String address, String city, String pincode, PurchaseOrder purchaseOrder,
            Customer customer) {
        this.shippingid = shippingid;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.purchaseOrder = purchaseOrder;
        this.customer = customer;
    }

    public Long getshippingid() {
        return shippingid;
    }

    public void setshippingid(Long purchaseOrderid) {
        this.shippingid = purchaseOrderid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
