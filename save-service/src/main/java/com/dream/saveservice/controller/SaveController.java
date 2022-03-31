package com.dream.saveservice.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dream.saveservice.service.KafkaService;
import com.dream.saveservice.service.SaveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class SaveController {
	private SaveService service;
	private KafkaService serv;

//	//keycloak 세션 정보 받고 나서 본인 아이디 검색
//	@RolesAllowed({ "USER" })
//	@GetMapping("/check")
//	public String orderCheck(Principal principal, Model model) {
//		log.info("---------------------- save/check URL 이동 -----------------------");
//		JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
//		String userId = (String) (token).getTokenAttributes().get("preferred_username");
//		service.select(userId);
//		model.addAttribute("list", service.select(userId));
//		model.addAttribute("keycloakList", token.getTokenAttributes());
//		return "orderCheck";
//	}

	@RolesAllowed({ "USER" })
	@GetMapping("/kafka")
	public String sendMsg(String message, Model model, Principal principal)
			throws JsonMappingException, JsonProcessingException {
		log.info("---------------------- save/check URL 이동 -----------------------");
		JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
		String userId = (String) (token).getTokenAttributes().get("preferred_username");
		service.select(userId);
		log.info("여기는?-------------------------------------");
		log.info("test = {}" + serv.getMessage().getOrderPrice()); // ->여기부터가 오류인데.....
		log.info("--------------------------- 오나?--------------");
		model.addAttribute("list", service.select(userId));
		model.addAttribute("keycloakList", token.getTokenAttributes());
//		model.addAttribute("test", serv.listener(message));
		String msg = "orderPrice : " + serv.getMessage().getOrderPrice() + ", proNo : " + serv.getMessage().getProNo()
				+ ", Term : " + serv.getMessage().getTerm() + ", userId : " + serv.getMessage().getUserId();
		model.addAttribute("test", msg);
		return "orderCheck";
	}
}
