package com.dance.east.mapper.dance;

import com.dance.east.entity.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface TeacherMapper {
    public List<TeacherInfo> getAll();
    public List<TeacherInfo> queryByName(String teacherName);
    public List<TeacherInfo> queryByTeacherNo(String teacherNO);
    public TeacherInfo queryById(Long id);
}
