package com.dream.listservice.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dream.listservice.service.ListService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Controller
@AllArgsConstructor
@Slf4j
public class ListController {
	private ListService service;
	
	@RolesAllowed({ "MANAGER", "ADMIN" })
	   @GetMapping("/all")
	   public String selectAll(Model model, Principal principal) {
			log.info("----------------------list/all/ URL 이동-----------------------");
			model.addAttribute("list", service.selectAll());
			JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
			model.addAttribute("keycloakList", token.getTokenAttributes());
			return "list";
	   }
}
