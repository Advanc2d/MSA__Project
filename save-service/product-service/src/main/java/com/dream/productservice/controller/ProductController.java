package com.dream.productservice.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dream.productservice.dto.ProductDto;
import com.dream.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {	
	private final ProductService productService;
	
	@RolesAllowed({ "USER" })
	@GetMapping("/list")
	public String dream(Model model) throws Exception {
		List<ProductDto> product = productService.getProductList();
		model.addAttribute("dream", product);
		return "productList";
	}
}
