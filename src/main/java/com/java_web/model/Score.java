package com.java_web.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tblscore")
@Getter
@Setter
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer id;
    @Column(name = "score_times")
    private Integer times;
    @Column(name = "score_type")
    private String type;
    @Column(name = "score_created_time")
    private String createdTime;
    @Column(name = "score_deleted")
    private byte deleted;
    @Column(name = "score_modified_time")
    private String modifiedTime;
    @Column(name = "score_note")
    private String note;
    @Column(name = "score_value")
    private BigDecimal score;
    @Column(name = "score_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subject subject;

}