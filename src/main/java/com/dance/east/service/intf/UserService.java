package com.dance.east.service.intf;

import com.dance.east.vo.UserDetailVo;

import java.util.List;

public interface UserService {
    public List<UserDetailVo> queryUserDetailByName(String userName);
}
