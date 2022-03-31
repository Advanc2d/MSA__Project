package com.dream.menuservice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MenuController {
	@GetMapping("/list")
	public String menu() {
		return "menu";
	}
}