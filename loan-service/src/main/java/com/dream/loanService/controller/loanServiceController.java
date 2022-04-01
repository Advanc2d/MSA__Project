package com.dream.loanService.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.keycloak.enums.TokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dream.loanService.domain.Message;
import com.dream.loanService.domain.loanProductVO;
import com.dream.loanService.service.loanService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class loanServiceController {
	private final loanService service;

	@RolesAllowed({ "USER" })
	@GetMapping("/apply")
	public String apply(@RequestParam(value = "proNo") int proNO, Model model, Principal principal) {
		log.info("----------------------loan/apply/ URL 이동-----------------------");
		loanProductVO proVO = new loanProductVO();
		proVO = service.bringLoan(proNO);
		model.addAttribute("proVO", proVO);

		System.out.println("여기까지는 담겼다");

		JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
		model.addAttribute("list", token.getTokenAttributes());

		log.info("html로 보내기 직전 토큰확인" + token.getTokenAttributes().toString());
		return "apply";
	}

	// kafka producer
	@Autowired
	private final KafkaTemplate<String, Message> kafkaTemplate;

	@Value(value = "${kafka.topic_name}")
	private String kafkaTopicName;

	@Value(value = "${kafka.server_endpoint}")
	private String kafkendPoinst;

	String status = "";

	@RequestMapping(value = "/kafka", method = RequestMethod.POST)
	public ResponseEntity<String> sendMessage(@RequestBody Message message) {
		log.info("----------------------loan/kafka/ URL 작동-----------------------");
		log.info("메세지 전동 된다. {}", message);

		ListenableFuture<SendResult<String, Message>> future = this.kafkaTemplate.send(kafkaTopicName, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

			@Override
			public void onSuccess(SendResult<String, Message> result) {
				status = "Message send successfully, 메시지가 성공적으로 전송 됨.";
				log.info("메시지가 성공적으로 전송됨. successfully sent message = {}, with offset = {}", message,
						result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("Failed to send message = {}, error = {}", message, ex.getMessage());
				status = "Message sending failed = 메시지 전송 실패...";
			}
		});

		return ResponseEntity.ok(status);
	}

	@GetMapping("/err")
	public String err() {
		return "err";
	}

}
