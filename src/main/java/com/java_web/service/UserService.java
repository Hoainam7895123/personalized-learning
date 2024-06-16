package com.java_web.service;

import com.java_web.dto.reuqest.UserDTO;

public interface UserService {
    public UserDTO addUser(UserDTO userDTO);
    public UserDTO getById(Integer id);
}
