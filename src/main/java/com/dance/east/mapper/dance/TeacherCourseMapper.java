package com.dance.east.mapper.dance;

import com.dance.east.entity.TeacherCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface TeacherCourseMapper {
    public List<TeacherCourse> getAll();
    public List<TeacherCourse> queryByTeacherId(Long teacherId);
    public List<TeacherCourse> queryByCourseId(Long courseId);
}
