package com.dream.saveservice.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.dream.saveservice.dto.MessageVo;
import com.dream.saveservice.dto.SaveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaService {
	@Autowired
	private SaveService service;
	
	private static MessageVo vo;
	
	@KafkaListener(topics="my-topic", groupId="consumer-1")
	public void listener(String message) throws JsonMappingException, JsonProcessingException {
		log.info("Received message = {}", message);
		
		ObjectMapper mapper = new ObjectMapper();
		SaveDto dto = new SaveDto();
		vo = mapper.readValue(message, MessageVo.class);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		dto.setProNo(Integer.parseInt(vo.getProNo()));
		dto.setUserId(vo.getUserId());
		dto.setOrderPrice(Double.parseDouble(vo.getOrderPrice()));

		dto.setOrderDate(cal.getTime());
		cal.add(Calendar.YEAR, Integer.parseInt(vo.getTerm()));

		dto.setEndDate(cal.getTime());
		
		service.save(dto);
		
		log.info(message);
	}
	
	public MessageVo getMessage() {
		return vo;
	}
}
