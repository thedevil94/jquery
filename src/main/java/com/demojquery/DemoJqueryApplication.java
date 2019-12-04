package com.demojquery;

import com.demojquery.service.BookService;
import com.demojquery.service.BookServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("com.demojquery.controller")
@SpringBootApplication
@EnableSpringDataWebSupport
@EnableWebMvc
@Configuration
public class DemoJqueryApplication {

    @Bean
    public BookService bookService(){
        return new BookServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoJqueryApplication.class, args);
    }

}
