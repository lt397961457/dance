package com.dance.east.mapper.dynamic;

import com.dance.east.entity.TeacherImg;

import java.util.List;

public interface DynamicTeacherImageMapper {
    public List<TeacherImg> getAll();
    public List<TeacherImg> queryByTeacherId(Long teacherId);
    public TeacherImg queyById(Long id);
}
