package com.dream.listservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dream.listservice.dto.ListDto;

@Repository
@Mapper
public interface ListMapper {
	public List<ListDto> selectAll();
}
