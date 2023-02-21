package arp.project.spring.learnspringboot.springdatajpa;

import arp.project.spring.learnspringboot.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

}
