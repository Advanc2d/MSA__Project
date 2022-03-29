package com.dream.loanService.service;

import org.springframework.stereotype.Service;

import com.dream.loanService.domain.loanProductVO;
import com.dream.loanService.mapper.loanMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class loanServiceImpl implements loanService {
	
	private final loanMapper mapper;
	
	@Override
	public loanProductVO bringLoan(int proNo) {

		log.info("----------------------loan-service mapper.xml 작동-----------------------");
		return mapper.bringLoan(proNo);
	}
	
}
