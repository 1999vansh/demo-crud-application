package com.vansh.crudDemo.service;

import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.repository.CourseRepositoryInterface;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseServiceTest {
    @Mock
    private CourseRepositoryInterface courseRepositoryInterface;
    @InjectMocks
    private CourseService courseService;

    @Test
    @Order(1)
    public void testAddCourse() {
        Course expectedResult = new Course(1, "Java", "Rs.2000", "2months");

        when(courseRepositoryInterface.save(any())).thenReturn(expectedResult);
        Course actualResult = courseService.addCourse(expectedResult);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @Order(2)
    public void testAddCourseNegative() {
        Course expectedResult = new Course(1, "Java", "Rs.2000", "2months");

        when(courseRepositoryInterface.save(any())).thenReturn(null);
        Course actualResult = courseService.addCourse(expectedResult);

        assertNull(actualResult);
    }

    @Test
    @Order(3)
    public void testGetAllCourse() {
        List<Course> expectedResult = new ArrayList<>();
        Course course = new Course(1, "Java", "Rs.2000", "2months");
        Course course1 = new Course(2, "NodeJs", "Rs.1000", "1month");
        expectedResult.add(course);
        expectedResult.add(course1);

        when(courseRepositoryInterface.findAll()).thenReturn(expectedResult);
        List<Course> actualResult = courseService.getAllCourse();

        assertEquals(expectedResult.size(), actualResult.size());
    }

    @Test
    @Order(4)
    public void testGetCourse() {
        Course expectedResult = new Course(1, "Java", "Rs.2000", "2months");

        when(courseRepositoryInterface.findById(any())).thenReturn(Optional.of(expectedResult));
        Course actualResult = courseService.getCourse(1);

        assertEquals(expectedResult.getId(), actualResult.getId());
    }

    @Test
    @Order(5)
    public void testUpdateCourse() {
        Course expectedResult = new Course(1, "Java", "Rs.2000", "2months");

        when(courseRepositoryInterface.findById(any())).thenReturn(Optional.of(expectedResult));
        when(courseRepositoryInterface.save(any())).thenReturn(expectedResult);
        Course actualResult = courseService.getCourse(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @Order(6)
    public void testDeleteCourse() {
        Course course = new Course(1, "Java", "Rs.2000", "2months");
        courseService.deleteCourse(course.getId());

        verify(courseRepositoryInterface, times(1)).deleteById(course.getId());
    }
}
