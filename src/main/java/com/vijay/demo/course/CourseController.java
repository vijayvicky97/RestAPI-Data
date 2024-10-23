package com.vijay.demo.course;

import com.vijay.demo.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService; //marks that this needs DI

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getTopics(@PathVariable String topicId){

        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getTopic(@PathVariable String id, @PathVariable String topicId){
        return courseService.getCourse(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
    public void setTopic(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.setCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void putTopic(@RequestBody Course course,@PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.putCourse(course);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}
