package com.dream.saveservice.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dream.saveservice.service.SaveService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class SaveController {
	private SaveService service;
	
	// keycloak 세션 정보 받고 나서 본인 아이디 검색
	   @RolesAllowed({ "USER" })
	   @GetMapping("/check")
	   public String orderCheck(Principal principal, Model model) {
		  log.info("---------------------- save/check URL 이동 -----------------------");
	      JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
	      String userId = (String) (token).getTokenAttributes().get("preferred_username");
	      service.select(userId);
	      model.addAttribute("list", service.select(userId));
	      model.addAttribute("keycloakList", token.getTokenAttributes());
	      return "orderCheck";
	   }
}
