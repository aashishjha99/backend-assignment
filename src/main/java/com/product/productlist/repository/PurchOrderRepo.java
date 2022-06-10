package com.product.productlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.productlist.model.PurchaseOrder;


@Repository
public  interface PurchOrderRepo extends JpaRepository<PurchaseOrder , Long>  {


@Query(value = "select *from  purchase_order where customer_customer_id = ?1",nativeQuery = true )
PurchaseOrder getPurchaseOrderid(long id);

    
@Query(value = " select *from purchase_order where customer_customer_id = ?1",nativeQuery = true)
PurchaseOrder getAllPurchaseDetails(long id);
}
