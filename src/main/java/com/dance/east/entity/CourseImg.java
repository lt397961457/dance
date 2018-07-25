package com.dance.east.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 课程图片信息
 */
@Entity
@Table(name = "course_img")
@Data
public class CourseImg {
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
    private Long courceID;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 图片描述
     *
     */
    @Column(name = "description") //desc 数据库关键字 需要重命名
    private String desc;
    /**
     * 图片显示优先级
     */
    private Integer level;
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    /**
     * 图片状态
     */
    private Byte status;
    /**
     * 是否是隐私照片
     */
    private Boolean isPrivacy;
}
