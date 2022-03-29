package com.dream.loanService.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dream.loanService.domain.loanProductVO;

@Repository
@Mapper
public interface loanMapper {
	
	public loanProductVO bringLoan(int proNo);
}
