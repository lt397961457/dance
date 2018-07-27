package com.dance.east.mapper.dynamic;

import com.dance.east.entity.CourseImg;

import java.util.List;

public interface DynamicCourseImgMapper {
    public List<CourseImg> getAll();
    public List<CourseImg> queryByCourceID(Long courceID);
}
