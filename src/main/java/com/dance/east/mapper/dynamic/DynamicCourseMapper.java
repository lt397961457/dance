package com.dance.east.mapper.dynamic;

import com.dance.east.entity.DanceCourese;

import java.util.List;

public interface DynamicCourseMapper {
    public List<DanceCourese> getAll();
    public List<DanceCourese> queryByTeacherId(Long teacherId);
    public List<DanceCourese> queryByCourseName(String courseName);
    public DanceCourese queryById(Long id);
    public DanceCourese queryByCourseNO(String courseNo);
}
