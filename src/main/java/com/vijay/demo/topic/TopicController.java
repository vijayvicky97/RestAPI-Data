package com.vijay.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService; //marks that this needs DI

    @RequestMapping("/topics")
    public List<Topic> getTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public void setTopic(@RequestBody Topic topic){
        topicService.setTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
    public void putTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.putTopic(topic, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

}
