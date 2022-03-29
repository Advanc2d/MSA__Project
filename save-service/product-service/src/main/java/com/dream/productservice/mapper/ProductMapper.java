package com.dream.productservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dream.productservice.dto.ProductDto;

@Repository
@Mapper
public interface ProductMapper {
	List<ProductDto> getProductList() throws Exception;
}
