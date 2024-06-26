package com.java_web;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;

import com.java_web.model.Score;
import com.java_web.model.Subject;
import com.java_web.repository.ScoreRepository;
import com.java_web.repository.SubjectRepository;
import com.java_web.service.ScoreService;
import com.java_web.service.SubjectService;

import lombok.AllArgsConstructor;

@SpringBootTest
class PersonalizedLearningApplicationTests {
	@Autowired
	private SubjectService ss;
	@Autowired
	private SubjectRepository sr;
	@Autowired
	private ScoreRepository scr;

	@Test
	void contextLoads() {
	}
	@Test
	void test() {
		List<Subject> list = sr.findStudy(1, 1);
		System.out.println(list.size());
		list.forEach(item -> {
			Score sc = scr.findBySub(1, item.getId());
			System.out.println(sc.getId());
		});
		
	}
}
