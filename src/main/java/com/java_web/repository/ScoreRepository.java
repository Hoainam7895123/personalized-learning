package com.java_web.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.java_web.model.Score;
import com.java_web.model.User;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
	List<Score> findByUser(User user);
}
