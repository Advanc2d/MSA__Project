package com.dream.statusservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dream.statusservice.dto.Datadto;
import com.dream.statusservice.dto.StatusDto;

@Repository
@Mapper
public interface StatusMapper {
	List<StatusDto> getStatusList() throws Exception;
	int getUpdate(Datadto dto);
}
