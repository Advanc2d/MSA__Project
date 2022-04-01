package com.dream.menuservice.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MenuController {
	@RequestMapping("/list")
	public String menu(Principal principal, Model model) {
		log.info("---------------------- menu/list URL 이동 -----------------------");
		if (principal != null) {
			JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
			log.info("toString : " + token.getTokenAttributes().toString());
			model.addAttribute("list", token.getTokenAttributes());
		}
		return "menu";
	}

	@RequestMapping("/test")
	public String authlogin(HttpServletRequest request) {
//        throw new RuntimeException("failed");
		try {
			Thread.sleep(50000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("request server port : {}", request.getServerPort());
		return "menu";
	}
}