package com.java_web.controller;

import com.java_web.dto.reuqest.TodoListDTO;
import com.java_web.dto.reuqest.UserDTO;
import com.java_web.model.StudyCredit;
import com.java_web.model.TodoList;
import com.java_web.model.User;
import com.java_web.repository.StudyCreditRepository;
import com.java_web.repository.TodoListRepository;
import com.java_web.repository.UserRepository;
import com.java_web.service.TodoListService;
import com.java_web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {

    private final StudyCreditRepository creditRepository;
    private final TodoListService todoListService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final TodoListRepository todoListRepository;

    @GetMapping("/credit/all")
    public List<StudyCredit> getAllCredit() {
        return creditRepository.findAll();
    }

//    @PostMapping("/todo/add/{userId}")
//    public ResponseEntity<String> addTodoList(@PathVariable Integer userId, @RequestBody TodoListDTO todoListDTO) {
//        todoListService.addTodoList(userId, todoListDTO);
//        return ResponseEntity.ok().body("Add to-do list for user successful");
//    }

    @GetMapping("/user")
    public UserDTO getById(@RequestParam("userId") Integer userId) {
        return userService.getById(userId);
    }
    @GetMapping("/users")
    public UserDTO getByIdx() {
        return userService.getById(1);
    }

    @GetMapping("/todo")
    public List<TodoListDTO> getAll(@RequestParam("userId") Integer userId) {
        return todoListService.getAllTodoList(userId);
    }

    @PostMapping("/delete-todo")
    public boolean delete(@RequestParam("todoId") Integer todoId) {
        return todoListService.deleteTodoList(todoId);

    }

    @PostMapping("/todo/add")
    public ResponseEntity<?> addTodoListx(@RequestBody TodoListDTO todoList,
                                          @RequestParam("userId") Integer userId) {
        todoListService.addTodoList(userId, todoList);
        return ResponseEntity.ok().body("Add to-do list for user successful");
    }

}
