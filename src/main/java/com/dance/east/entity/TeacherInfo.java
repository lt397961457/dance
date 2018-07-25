package com.dance.east.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 教师信息
 */
@Entity
@Table(name = "teacher_info")
@Data
public class TeacherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    /**
     * 老是编号
     */
    private String teacherNO;
    /**
     * 老师姓名
     */
    private String teacherName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 地址
     */
    private String addr;
    /**
     * 身份证号码
     */
    private String  identificationCard;
    /**
     * 性别
     */
    private Byte sex;
    /**
     * 是否结婚
     */
    private Byte isMarried;
    /**
     * 描述信息
     */
    @Column(name = "description") //desc 数据库关键字 需要重命名
    private String desc;
}
