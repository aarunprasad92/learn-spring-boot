package arp.project.spring.learnspringboot.jdbc;

import arp.project.spring.learnspringboot.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
            """
            insert into course (id, name, author) 
            values(?, ?, ?);
            """;

    private static String SELECT_QUERY =
            """
            select * from course where
            id = ?;
            """;

    private static String DELETE_QUERY =
            """
            delete from course where
            id = ?;
            """;
    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long courseId) {
        springJdbcTemplate.update(DELETE_QUERY, courseId);
    }

    public Course findById(long courseId) {
        // mapping result set to bean -> Row mapper
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), courseId);
    }
}
