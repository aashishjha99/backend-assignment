package com.product.productlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.product.productlist.model.Customer;




@Repository
public  interface CutomerRepo extends JpaRepository<Customer,Long> {
    

@Query(value = "select *from Customer where email = ?1",nativeQuery= true)
Customer findbymail(String mail);



@Query(value = "select *from customer where city = ?1",nativeQuery = true)
List<Customer> findByCity(String city);

}
