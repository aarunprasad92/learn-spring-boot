package arp.project.spring.learnspringboot;

import arp.project.spring.learnspringboot.jdbc.CourseJdbcRepository;
import arp.project.spring.learnspringboot.jpa.CourseJpaRepository;
import arp.project.spring.learnspringboot.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Lambda", "arun"));
        repository.save(new Course(2, "Learn Docker", "arun"));
        repository.save(new Course(3, "Learn Kubernetes", "arun"));
        repository.save(new Course(4, "Learn Spring boot", "arun"));
        repository.save(new Course(5, "Learn Hibernate", "arun"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
    }
}
