package com.java_web.controller.TodoList;

import com.java_web.dto.reuqest.TodoListDTO;
import com.java_web.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoListHomePageController {

    private final TodoListService todoListService;

    @GetMapping("/page/todo-list")
    public String todoListPage(@RequestParam(name = "userId", required = false, defaultValue = "") Integer userId,
                               Model model) {
        List<TodoListDTO> todoListDTOS = todoListService.getAllTodoList(userId);
        model.addAttribute("todoLists", todoListDTOS);
        model.addAttribute("newTodo", new TodoListDTO()); // Thêm đối tượng TodoListDTO mới để binding form
        model.addAttribute("userId", userId);
        return "index";
    }
}
