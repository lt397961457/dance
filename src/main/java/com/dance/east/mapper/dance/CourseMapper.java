package com.dance.east.mapper.dance;

import com.dance.east.entity.DanceCourese;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface CourseMapper {
    public List<DanceCourese> getAll();
    public List<DanceCourese> queryByTeacherId(Long teacherId);
    public List<DanceCourese> queryByCourseName(String courseName);
    public DanceCourese queryById(Long id);
    public DanceCourese queryByCourseNO(String courseNo);
}
