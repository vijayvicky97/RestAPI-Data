package com.vijay.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){

        List<Course> courses = new ArrayList<>();

        courseRepository.findByTopicId(topicId)
                .forEach(courses:: add);
        return courses;
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).get();
    }

    public void setCourse(Course course){
        courseRepository.save(course);
    }

    public void putCourse(Course course){

        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    }
