package com.product.productlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.product.productlist.model.ShippingDetails;

@Repository
public interface ShippingDetRepo extends JpaRepository<ShippingDetails, Long> {



@Query(value = "select *from shipping_details where customer_customer_id =:customerId and purchase_order_purchase_order_id =:purcahseID",nativeQuery = true)
List<ShippingDetails> getShippingDetails(@Param("customerId")long custID ,@Param("purcahseID")long purcID);

}
