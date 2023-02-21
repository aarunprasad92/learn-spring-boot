package arp.project.spring.learnspringboot.jdbc;

import arp.project.spring.learnspringboot.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Lambda", "arun"));
        repository.insert(new Course(2, "Learn Docker", "arun"));
        repository.insert(new Course(3, "Learn Kubernetes", "arun"));
        repository.insert(new Course(4, "Learn Spring boot", "arun"));
        repository.insert(new Course(5, "Learn Hibernate", "arun"));

    }
}
