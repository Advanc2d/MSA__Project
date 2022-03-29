package com.dream.gatewayservice.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

   @GetMapping("/")
   public String index(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
      return authorizedClient.getAccessToken().getTokenValue();
   }

}