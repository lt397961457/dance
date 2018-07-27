package com.dance.east.mapper.dynamic;

import com.dance.east.entity.TeacherCourse;

import java.util.List;

public interface DynamicTeacherCourseMapper {
    public List<TeacherCourse> getAll();
    public List<TeacherCourse> queryByTeacherId(Long teacherId);
    public List<TeacherCourse> queryByCourseId(Long courseId);
}
