package com.vansh.crudDemo.service;
import com.vansh.crudDemo.entity.Course;
import java.util.List;

public interface CourseServiceInterface {

    public Course addCourse(Course c);

    public List<Course> getAllCourse();

    public Course getCourse(int id);

    public String deleteCourse(int id);

    public Course updateCourse(int id,Course c);
}
