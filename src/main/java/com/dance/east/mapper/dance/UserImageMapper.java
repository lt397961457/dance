package com.dance.east.mapper.dance;

import com.dance.east.entity.UserImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface UserImageMapper {
    public List<UserImg> getAll();
    public List<UserImg> queryByUserId(Long userId);
    public UserImg queryById(Long id);
}
