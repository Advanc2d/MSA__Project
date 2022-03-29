package com.dream.listservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dream.listservice.dto.ListDto;
import com.dream.listservice.mapper.ListMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService{
	private final ListMapper mapper;
	@Override
	public List<ListDto> selectAll() {
		log.info("----------------------list mapper.xml-----------------------");
		return mapper.selectAll();
	}

}
