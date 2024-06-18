package com.java_web.controller;

import com.java_web.dto.reuqest.TodoListDTO;
import com.java_web.service.SkillScoreService;
import com.java_web.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageController {

    private final SkillScoreService skillScoreService;
    private final TodoListService todoListService;

    @GetMapping("/")
    public String homePage(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        System.out.println(username);
        BigDecimal programmingSkill = skillScoreService.calculateProgrammingSkillPoint(1);
        BigDecimal designSkill = skillScoreService.calculateDesignSkillPoint(1);
        BigDecimal logicalThinking = skillScoreService.calculateLogicalThinkingPoint(1);
        BigDecimal interactionSkill = skillScoreService.calculateInteractionSkillPoint(1);
        List<TodoListDTO> todoListDTOS = todoListService.getAllTodoList(1);

        model.addAttribute("programmingSkill", programmingSkill);
        model.addAttribute("designSkill", designSkill);
        model.addAttribute("logicalThinking", logicalThinking);
        model.addAttribute("interactionSkill", interactionSkill);
        model.addAttribute("todos", todoListDTOS);
        return "index";
    }
}

