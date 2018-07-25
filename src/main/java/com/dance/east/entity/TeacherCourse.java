package com.dance.east.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 教师-课程 对应信息
 */
@Entity
@Table(name = "teacher_course_info")
@Data
public class TeacherCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    /**
     * 教师ID
     */
    private Long teacherID;
    /**
     * 课程ID
     */
    private Long courseID;
    /**
     * 描述
     */
    @Column(name = "description") //desc 数据库关键字 需要重命名
    private String desc;
    /**
     * 状态
     */
    private Byte status;
}
