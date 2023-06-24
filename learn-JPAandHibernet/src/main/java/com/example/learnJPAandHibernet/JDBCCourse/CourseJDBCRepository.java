package com.example.learnJPAandHibernet.JDBCCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {

	@Autowired
	private JdbcTemplate springjdbcTemplate;

	private static String INSERT_QUERY = """
			insert into course(id,name,author) values(?,?,?);
			""";
	
	private static String DELETE_QUERY = """
			delete from course where id = ?;
			""";

	public void insert(Course course) {
		springjdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	
	public void DeleteById(long id) {
		springjdbcTemplate.update(DELETE_QUERY, id);
	}

}
