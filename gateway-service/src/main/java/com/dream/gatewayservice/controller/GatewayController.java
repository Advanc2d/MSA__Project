package com.dream.gatewayservice.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GatewayController {

   @GetMapping("/")
   public String index(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
      return authorizedClient.getAccessToken().getTokenValue();
   }
   
   @RequestMapping("/fallback/Faliure")
   public ServerHttpResponse testFallback(ServerHttpRequest request, ServerHttpResponse response) {
	   log.info("fallback ...............");
       return response;
   }

}