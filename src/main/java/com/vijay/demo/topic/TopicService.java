package com.vijay.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    public List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring","spring Framework", "Spring despcription"),
                new Topic("Java","Java spring Framework2", "Java Spring despcription"),
                new Topic("Python","Python spring Framework3", "Python Spring despcription")
    ));

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){

        List<Topic> topics = new ArrayList<>();

        topicRepository.findAll()
                .forEach(topics:: add);
        return topics;
    }

    public Topic getTopic(String id){
        return topicRepository.findById(id).get();
    }

    public void setTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void putTopic(Topic topic, String id){

        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }

    }
