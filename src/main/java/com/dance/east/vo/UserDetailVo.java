package com.dance.east.vo;

import com.dance.east.entity.UserImg;
import com.dance.east.entity.UserInfo;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class UserDetailVo {
    private UserInfo userInfo;
    private List<UserImg> imgs;
}
