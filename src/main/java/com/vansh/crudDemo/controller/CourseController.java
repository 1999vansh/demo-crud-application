package com.vansh.crudDemo.controller;

import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping("/")
    @Operation(summary = "Get all courses details")
    public ResponseEntity<List<Course>> getAllCourse() {
        logger.info("Calling and starting getAllCourse()");
        List<Course> courses = courseService.getAllCourse();
        if (courses == null) {
            logger.error("Unable to fetch courses");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get course details by id")
    public ResponseEntity<Course> getCourse(@PathVariable int id) {
        logger.info("Calling and starting getCourse()");
        Course course = courseService.getCourse(id);
        if (course == null) {
            logger.error("Unable to fetch course");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @PostMapping("/")
    @Operation(summary = "Add course details")
    public ResponseEntity<Course> addCourse(@RequestBody Course c) {
        logger.info("Calling and starting addCourse()");
        Course course = courseService.addCourse(c);
        if (course == null) {
            logger.error("Unable to fetch course");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update course details by id")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course c) {
        logger.info("Calling and starting updateCourse()");
        Course course = courseService.updateCourse(id, c);
        if (course == null) {
            logger.error("Unable to update course");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete course details by id")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        logger.info("Calling and starting deleteCourse()");
        String response = courseService.deleteCourse(id);
        if (response == "Success") {
            return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
