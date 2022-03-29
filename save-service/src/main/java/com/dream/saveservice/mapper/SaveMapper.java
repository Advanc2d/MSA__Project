package com.dream.saveservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dream.saveservice.dto.SaveDto;

@Repository
@Mapper
public interface SaveMapper {
	public void save(SaveDto dto);
	
	public List<SaveDto> select(String userId);
}
