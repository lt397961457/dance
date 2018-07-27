package com.dance.east.mapper.dance;

import com.dance.east.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
public interface UserMapper {
    public List<UserInfo> getAll();
    public List<UserInfo> queryByUserName(String userName);
    public UserInfo queryById(Long id);
    public UserInfo queryByPhoneNum(String phoneNum);
    public List<UserInfo> queryByCondition(@Param(value = "paraMap")Map<String,Object> condition);
    void saveUser(UserInfo userInfo);
}
