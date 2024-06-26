package com.java_web.controller.schedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java_web.dto.reuqest.ScoreDTO;
import com.java_web.dto.reuqest.SubjectDTO;
import com.java_web.model.User;
import com.java_web.service.ScoreService;
import com.java_web.service.SubjectService;
import com.java_web.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ViewScheduleController {
	
	private ScoreService scoreService;
	private SubjectService subjectService;
	
	@GetMapping("/schedule")
	public String viewUserScore(Model model) {
		List<ScoreDTO> list = scoreService.getScoreByUser(2);
		model.addAttribute("scoreDetail", list);
		
		Map<String, List<SubjectDTO>> map = new HashMap();
		
		// Save list subject of each semester as map, if semester is empty, put expected subject instead
		for (int i=1; i<9; i++) {
			List<SubjectDTO> sub = subjectService.getStudy(2, i);
			if (!sub.isEmpty()) {
				map.put("sub"+i, sub);
			} else {
				sub = subjectService.getExpected(1);
				map.put("sub"+i, sub);
				break;
			}
		}
		
		model.addAllAttributes(map);
		
		return "schedule";
	}
}
