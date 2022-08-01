package com.vansh.crudDemo.service;

import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.repository.CourseRepositoryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements CourseServiceInterface {
    @Autowired
    private CourseRepositoryInterface courseRepository;

    private final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Override
    public Course addCourse(Course c) {
        Course course = null;
        try {
            course = courseRepository.save(c);
        } catch (Exception e) {
            logger.error("Error in addCourse() method - " + e.getMessage());
        }
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> c = new ArrayList<>();
        try {
            c = courseRepository.findAll();
        } catch (Exception e) {
            logger.error("Error in getAllCourse() method - " + e.getMessage());
        }
        return c;
    }

    @Override
    public Course getCourse(int id) {
        Course course = null;
        try {
            course = courseRepository.findById(id).get();
        } catch (Exception e) {
            logger.error("Error in getCourse() method - " + e.getMessage());
        }
        return course;
    }

    @Override
    public String deleteCourse(int id) {
        try {
            courseRepository.deleteById(id);
            return "Success";
        } catch (Exception e) {
            logger.error("Error in deleteCourse() method - " + e.getMessage());
            return "Failure";
        }
    }

    @Override
    public Course updateCourse(int id, Course c) {
        Course obj = null;
        try {
            obj = courseRepository.findById(id).get();
            obj.setCourseName(c.getCourseName());
            obj.setCourseDuration(c.getCourseDuration());
            obj.setCourseFees(c.getCourseFees());
        } catch (Exception e) {
            logger.error("Error in updateCourse() method - " + e.getMessage());
        }
        return courseRepository.save(obj);
    }
}
