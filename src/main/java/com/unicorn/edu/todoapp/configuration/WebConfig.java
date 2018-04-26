package com.unicorn.edu.todoapp.configuration;

import com.unicorn.edu.todoapp.controller.TaskController;
import com.unicorn.edu.todoapp.service.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.unicorn.edu.todoapp" })
public class WebConfig extends WebMvcConfigurationSupport {
    @Bean
    public TaskController taskController () {
        return new TaskController();
    }


}
