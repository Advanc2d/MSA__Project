package com.dream.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dream.productservice.dto.ProductDto;
import com.dream.productservice.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;

	@Override
	public List<ProductDto> getProductList() throws Exception {
		return productMapper.getProductList();
	}
}