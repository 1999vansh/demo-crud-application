package com.vansh.crudDemo.service;
import com.vansh.crudDemo.dto.CourseDto;
import com.vansh.crudDemo.entity.Course;
import java.util.List;

public interface CourseService {

    public CourseDto addCourse(CourseDto c);

    public List<Course> getAllCourse();

    public CourseDto getCourse(int id);

    public String deleteCourse(int id);

    public CourseDto updateCourse(int id,CourseDto c);
}
