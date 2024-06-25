package com.java_web.controller.score;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java_web.dto.reuqest.ScoreDTO;
import com.java_web.model.User;
import com.java_web.service.ScoreService;
import com.java_web.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ViewScoreController {
	
	private ScoreService scoreService;
	
	@GetMapping("/schedule")
	public String viewUserScore(Model model) {
		List<ScoreDTO> list = scoreService.getScoreByUser(1);
		model.addAttribute("scoreDetail", list);
		
		return "schedule";
	}
}
