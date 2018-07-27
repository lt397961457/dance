package com.dance.east.mapper.dynamic;

import com.dance.east.entity.UserImg;

import java.util.List;

public interface DynamicUserImageMapper {
    public List<UserImg> getAll();
    public List<UserImg> queryByUserId(Long userId);
    public UserImg queryById(Long id);
    void saveUserImg(UserImg userImg);
    void batchSave(List<UserImg> imgs);
}
