package com.dream.statusservice.service;

import java.util.List;

import com.dream.statusservice.dto.Datadto;
import com.dream.statusservice.dto.StatusDto;

public interface StatusService {
	public List<StatusDto> getStatusList() throws Exception;
	public int getUpdate(Datadto dto);
}
