package com.popse.service;

import com.popse.dao.CourseMapper;
import com.popse.pojo.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService{

    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public Course findCourseById(int courseId) {
        return courseMapper.findCourseById(courseId);
    }

    @Override
    public ArrayList<Course> findCourseByName(String courseName) {
        return courseMapper.findCourseByName(courseName);
    }

    @Override
    public ArrayList<Course> findCourseByIdAndName(int courseId, String courseName) {
        return courseMapper.findCourseByIdAndName(courseId, courseName);
    }

    @Override
    public ArrayList<Course> findCourseByAcademyId(int academyId) {
        return courseMapper.findCourseByAcademyId(academyId);
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int deleteCourse(int courseId) {
        return courseMapper.deleteCourse(courseId);
    }

    @Override
    public Map<String, Object> findCourseAndAcademyById(int courseId) {
        return courseMapper.findCourseAndAcademyById(courseId);
    }

    @Override
    public List<Map<String, Object>> findCourseAndAcademyAll() {
        return courseMapper.findCourseAndAcademyAll();
    }
}
