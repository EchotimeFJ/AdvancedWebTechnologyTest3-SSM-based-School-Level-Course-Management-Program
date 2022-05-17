package com.popse.dao;

import com.popse.pojo.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CourseMapper {

    /**
     * @Description: 根据课程ID获取课程信息
     * @Param courseId:
     * @Return: com.popse.pojo.Course
     **/
    public Course findCourseById(int courseId);

    /**
     * @Description: 根据课程名模糊查询课程信息列表 或 查询所有课程信息列表
     * @Param courseName:
     * @Return: java.util.ArrayList<com.popse.pojo.Course>
     **/
    public ArrayList<Course> findCourseByName(String courseName);

    /**
     * @Description: 查找id不为courseId但课程名为courseName的数据
     * @Param courseName:
     * @Return: java.util.ArrayList<com.popse.pojo.Course>
     **/
    public ArrayList<Course> findCourseByIdAndName(int courseId, String courseName);
    
    /**
     * @Description: 根据学院ID获取课程信息列表
     * @Param academyId:
     * @Return: java.util.ArrayList<com.popse.pojo.Course>
     **/
    public ArrayList<Course> findCourseByAcademyId(int academyId);

    /**
     * @Description: 添加课程信息
     * @Param course:
     * @Return: int
     **/
    public int addCourse(Course course);

    /**
     * @Description: 更新课程信息
     * @Param course:
     * @Return: int
     **/
    public int updateCourse(Course course);

    /**
     * @Description: 删除课程信息
     * @Param courseId:
     * @Return: int
     **/
    public int deleteCourse(int courseId);

    public Map<String, Object> findCourseAndAcademyById(int courseId);

    public List<Map<String, Object>> findCourseAndAcademyAll();
}
