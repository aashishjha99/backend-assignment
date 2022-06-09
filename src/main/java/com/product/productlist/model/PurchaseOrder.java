package com.product.productlist.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "purchaseOrder")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseOrderId;

    @NonNull
    private String productName;

    @NonNull
    private int quantity;
    @NonNull
    private int pricing;
    @NonNull
    private int mrp;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    
    


    public PurchaseOrder() {

    }


    public PurchaseOrder(Long purchaseOrderId, String productName, int quantity, int pricing, int mrp,
            Customer customer) {
        this.purchaseOrderId = purchaseOrderId;
        this.productName = productName;
        this.quantity = quantity;
        this.pricing = pricing;
        this.mrp = mrp;
        this.customer = customer;
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPricing() {
        return pricing;
    }

    public void setPricing(int pricing) {
        this.pricing = pricing;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
