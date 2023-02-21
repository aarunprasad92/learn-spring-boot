package arp.project.spring.learnspringboot;

import arp.project.spring.learnspringboot.jdbc.CourseJdbcRepository;
import arp.project.spring.learnspringboot.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Lambda", "arun"));
        repository.insert(new Course(2, "Learn Docker", "arun"));
        repository.insert(new Course(3, "Learn Kubernetes", "arun"));
        repository.insert(new Course(4, "Learn Spring boot", "arun"));
        repository.insert(new Course(5, "Learn Hibernate", "arun"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
