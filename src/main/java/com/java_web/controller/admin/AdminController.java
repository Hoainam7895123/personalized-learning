package com.java_web.controller.admin;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java_web.dto.reuqest.StatDTO;
import com.java_web.service.StatisticService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AdminController {
	
	private StatisticService statisticService;
	
	@GetMapping("/admin")
	public String dashboard(Model model) {
		
		List<StatDTO> list = statisticService.getAvgScore();
		
		List<Integer> userId = new ArrayList<>();
		List<String> user = new ArrayList<>();
		List<String> userScore = new ArrayList<>();
		List<Integer> total = new ArrayList<>();
		
		try {
			DecimalFormat df = new DecimalFormat("#.##");
			list.forEach(item -> {
				user.add(item.getId()+" "+item.getName());
				userScore.add(df.format(item.getScore()));
				total.add(item.getTotal());
			});
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		model.addAttribute("user", user);
		model.addAttribute("score", userScore);
		model.addAttribute("total", total);
		
		return "admin/index";
	}
}
