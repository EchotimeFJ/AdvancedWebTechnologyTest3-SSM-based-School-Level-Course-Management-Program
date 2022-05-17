package com.popse.pojo;

public class Course {
    private int courseId;
    private String courseName;
    private int courseHours;
    private int academyId;
    private int courseImage;

    public Course() {
    }

    public Course(String courseName, int courseHours, int academyId) {
        this.courseName = courseName;
        this.courseHours = courseHours;
        this.academyId = academyId;
    }

    public Course(int courseId, String courseName, int courseHours, int academyId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseHours = courseHours;
        this.academyId = academyId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(int courseHours) {
        this.courseHours = courseHours;
    }

    public int getAcademyId() {
        return academyId;
    }

    public void setAcademyId(int academyId) {
        this.academyId = academyId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseHours=" + courseHours +
                ", academyId=" + academyId +
                '}';
    }
}
