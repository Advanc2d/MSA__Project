package com.dream.saveservice.service;

import java.util.List;

import com.dream.saveservice.dto.SaveDto;

public interface SaveService {
	public void save(SaveDto dto);
	
	public List<SaveDto> select(String userId);
}
