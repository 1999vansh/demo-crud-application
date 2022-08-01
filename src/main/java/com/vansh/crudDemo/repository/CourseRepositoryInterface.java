package com.vansh.crudDemo.repository;

import com.vansh.crudDemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositoryInterface extends JpaRepository<Course, Integer> {

}
