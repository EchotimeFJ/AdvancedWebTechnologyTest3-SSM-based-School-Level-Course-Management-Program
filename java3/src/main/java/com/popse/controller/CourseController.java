package com.popse.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.popse.pojo.Course;
import com.popse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService courseService;

    @RequestMapping("/courseList")
    public String toCourseList() {
        return "courseList";
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> findCourseByName() {
        Map<String, Object> res = new HashMap<>();
        List<Object> obj = new ArrayList<>();
        List<Map<String, Object>> courses = courseService.findCourseAndAcademyAll();
        for(Map<String, Object> course : courses) {
            obj.add(course);
        }
        res.put("length", courses.size());
        res.put("value", obj);
        return res;
    }

    @RequestMapping("/delete")
    public String deleteCourse(Integer courseId) {
        int i = courseService.deleteCourse(courseId);
        return "redirect:/course/courseList";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Model model, int courseId) {
        Course course = courseService.findCourseById(courseId);
        model.addAttribute("course", course);
        return "courseUpdate";
    }

    @RequestMapping(value = "/updateIsOk", produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String updateIsOk(int courseId, String courseName) {
        ArrayList<Course> courseList = courseService.findCourseByIdAndName(courseId, courseName);
        if(courseList.size()==0) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/update")
    public String updateCourse(Course course) {
        int i = courseService.updateCourse(course);
        return "redirect:/course/courseList";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "courseAdd";
    }

    @RequestMapping(value = "/addIsOk", produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String addIsOk(String courseName) {
        ArrayList<Course> courseList = courseService.findCourseByName(courseName);
        if(courseList.size()==0) {
            return "true";
        }
        return "false";
    }
    @RequestMapping("/add")
    public String addCourse(Course course) {
        int i = courseService.addCourse(course);
        return "redirect:/course/courseList";
    }
}
