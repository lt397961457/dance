package com.dance.east.mapper.dance;

import com.dance.east.entity.TeacherImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface TeacherImageMapper {
    public List<TeacherImg> getAll();
    public List<TeacherImg> queryByTeacherId(Long teacherId);
    public TeacherImg queyById(Long id);
}
