package com.dance.east.mapper.dance;

import com.dance.east.entity.CourseImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface CourseImgMapper {
    public List<CourseImg> getAll();
    public List<CourseImg> queryByCourceID(Long courceID);
}
