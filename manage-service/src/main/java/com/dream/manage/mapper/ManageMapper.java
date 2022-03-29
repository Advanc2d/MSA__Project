package com.dream.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dream.manage.dto.ManageDto;

@Repository
@Mapper
public interface ManageMapper {
	
	public void register(ManageDto dto);
}