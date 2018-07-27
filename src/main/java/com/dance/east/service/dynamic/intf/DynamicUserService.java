package com.dance.east.service.dynamic.intf;

import com.dance.east.vo.UserDetailVo;

import java.util.List;

public interface DynamicUserService {
    public List<UserDetailVo> queryUserDetailByName(String userName);
    public Boolean saveUserDetail(UserDetailVo vo);
}
