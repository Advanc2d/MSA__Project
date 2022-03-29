package com.dream.statusservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dream.statusservice.dto.Datadto;
import com.dream.statusservice.dto.StatusDto;
import com.dream.statusservice.mapper.StatusMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
	private final StatusMapper statusMapper;

	@Override
	public List<StatusDto> getStatusList() throws Exception {
		return statusMapper.getStatusList();
	}
	
	@Override
	public int getUpdate(Datadto dto){
		return statusMapper.getUpdate(dto);
	}
}