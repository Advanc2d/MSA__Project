package com.dream.productservice.service;

import java.util.List;

import com.dream.productservice.dto.ProductDto;

public interface ProductService {
	public List<ProductDto> getProductList() throws Exception;
}
