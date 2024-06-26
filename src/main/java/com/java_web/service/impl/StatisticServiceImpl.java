package com.java_web.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java_web.dto.reuqest.StatDTO;
import com.java_web.repository.StatisticRepository;
import com.java_web.service.StatisticService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatisticServiceImpl implements StatisticService{
	
	private StatisticRepository statisticRepository;
	
	@Override
	public List<StatDTO> getAvgScore() {
		List<StatDTO> list = new ArrayList<StatDTO>();
		
		List<Object[]> rawList = statisticRepository.getAvgScore();
		for (Object[] rawItem : rawList) {
			
			int id = (Integer) rawItem[0];
			String name = (String) rawItem[1];
			BigDecimal rscore = (BigDecimal) rawItem[2];
			float score = rscore.floatValue();
			Long rtotal = (Long) rawItem[3];
			int total = rtotal.intValue();
			
			StatDTO item = new StatDTO(id, name, score, total);
			
			list.add(item);
		}
		
		return list;
	}
	
}
