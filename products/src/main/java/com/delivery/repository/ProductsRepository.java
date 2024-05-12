package com.delivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.dto.ProductDto;
import com.delivery.entity.Products;
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

	List<Products> findByMobileNumber(String mobileNumber);
	Optional<Products> findByProductUid(long productUid);

}
