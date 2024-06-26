package com.java_web.repository;

import com.java_web.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query(value="select s.user_id as id, "
            + "u.user_fullname as name, "
            + "avg(s.score_value) as score, "
            + "count(s.score_id) as total "
            + "from tblscore s inner join tbluser u on s.user_id = u.user_id "
            + "where s.score_status = 'done' "
            + "group by s.user_id;", nativeQuery = true)
    public List<Object[]> getAvgScore();
}
