package com.dance.east.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 客户基本信息
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 住址
     */
    private String addr;
    /**
     * 手机号
     */
    private String phoneNum;
    /**
     * 性别
     */
    private Byte sex;
    /**
     * 爱好，兴趣
     */
    private String faverate;

    /**
     * 用户状态
     */
    private Byte status;
}
