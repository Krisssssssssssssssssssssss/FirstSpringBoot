package com.example.FirstSpringBoot.controller;
import com.example.FirstSpringBoot.Message;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class HelloController {
    private List<Message> messages = new ArrayList<>();

    @GetMapping("/api/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @PostMapping("/api/messages")
    public String createMessage(@RequestBody Message newMessage) {
        messages.add(newMessage);
        return "Message received and stored for user: " + newMessage.getName();
    }


    @GetMapping("/api/messages")
    public List<Message> getAllMessages() {
        return messages;
    }
    @DeleteMapping("/api/messages/{id}")
    public String deleteMessageById(@PathVariable String id) {
        Iterator<Message> iterator = messages.iterator();
        while (iterator.hasNext()) {
            Message message = iterator.next();
            if (message.getId().equals(id)) {
                iterator.remove();  // Remove the message from the list
                return "Message with ID " + id + " deleted successfully.";
            }
        }
        return "Message with ID " + id + " not found.";
    }
}