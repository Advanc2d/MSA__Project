package com.dream.loanService.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class loanOrderVO {
	
	private int orderNo;
	private int proNo;
	private String userId;
	private double orderPrice;
	private Date orderDate;
	private Date endDate;
}
