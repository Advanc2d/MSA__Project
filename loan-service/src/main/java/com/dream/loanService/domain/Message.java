package com.dream.loanService.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

//8005번으로 보내는 데이터 전송 개체

@Data
@JsonAutoDetect
public class Message {
	
	private String proNo;
	private String userId;
	private String orderPrice;
	private String term;

}
