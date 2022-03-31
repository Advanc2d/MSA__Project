package com.dream.menuservice.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MenuController {
	@RequestMapping("/list")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping("/test")
    public String authlogin(HttpServletRequest request){
//        throw new RuntimeException("failed");
        try{
            Thread.sleep(50000);
        }catch(Exception e){
            e.printStackTrace();
        }
        log.info("request server port : {}" , request.getServerPort());
        return "menu";
    }
}