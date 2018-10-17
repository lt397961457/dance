package com.dance.east.vo;

import com.dance.east.entity.UserImg;
import com.dance.east.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class UserDetailVo {
    public interface MyView{};
    @JsonView(MyView.class)
    private UserInfo userInfo;
    @JsonView(MyView.class)
    private List<UserImg> imgs;
}
