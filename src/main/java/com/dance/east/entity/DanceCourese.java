package com.dance.east.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 课程信息
 */
@Entity
@Table(name = "course_info")
@Data
public class DanceCourese {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    /**
     * 课程编号
     */
    private String courseNO;
    /**
     *课程名称
     */
    private String courseName;
    /**
     * 默认授课老师
     */
    private Long teacherId;
    /**
     * 开课时间
     */
    private Date openningTime;
    /**
     * 课程结束时间
     */
    private Date endTime;
    /**
     * 平均课时时长，分钟
     */
    private Long classHour;
    /**
     * 总课时
     */
    private Long classNum;
    /**
     * 描述信息
     */
    private String description;
}
