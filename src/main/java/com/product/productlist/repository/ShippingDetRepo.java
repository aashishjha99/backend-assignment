package com.product.productlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.productlist.model.ShippingDetails;

@Repository
public interface ShippingDetRepo extends JpaRepository<ShippingDetails, Long> {

}
