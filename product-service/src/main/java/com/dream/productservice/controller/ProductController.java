package com.dream.productservice.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dream.productservice.dto.ProductDto;
import com.dream.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {	
	private final ProductService productService;
	
	@GetMapping("/list")
	public String dream(Model model) throws Exception {
		log.info("---------------------- prodcut/list URL 이동 -----------------------");
		List<ProductDto> product = productService.getProductList();
		model.addAttribute("dream", product);
		return "productList";
	}
}
