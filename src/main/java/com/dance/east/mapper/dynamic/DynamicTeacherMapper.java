package com.dance.east.mapper.dynamic;

import com.dance.east.entity.TeacherInfo;

import java.util.List;

public interface DynamicTeacherMapper {
    public List<TeacherInfo> getAll();
    public List<TeacherInfo> queryByName(String teacherName);
    public List<TeacherInfo> queryByTeacherNo(String teacherNO);
    public TeacherInfo queryById(Long id);
}
