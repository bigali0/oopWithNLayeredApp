package oopWithNLayeredApp;

import oopWithNLayeredApp.business.CategoryManager;
import oopWithNLayeredApp.business.CourseManager;
import oopWithNLayeredApp.business.InstructorManager;
import oopWithNLayeredApp.core.logging.DatabaseLogger;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.core.logging.MailLogger;
import oopWithNLayeredApp.dataAccess.category.JdbcCategoryDao;
import oopWithNLayeredApp.dataAccess.course.JdbcCourseDao;
import oopWithNLayeredApp.dataAccess.instructor.HibernateInstructorDao;
import oopWithNLayeredApp.entities.Category;
import oopWithNLayeredApp.entities.Course;
import oopWithNLayeredApp.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		List<Logger> loggers=new ArrayList<>();
		loggers.add(new DatabaseLogger());
		loggers.add(new FileLogger());
		loggers.add(new MailLogger());

		Category category1 = new Category(1, "Programlama");
		Category category2 = new Category(2, "Cyber Security");

		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(),loggers);

		categoryManager.add(category1);
		categoryManager.add(category2);


		categoryManager.update(0, category2);
		categoryManager.delete(category1.getId()-1);


		Instructor instructor1 = new Instructor(1,"Engin Demirog",7);
		Instructor instructor2 = new Instructor(2,"Adnan",1);

		InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(),loggers);
		instructorManager.add(instructor1);
		instructorManager.add(instructor2);
		instructorManager.update(instructor2.getId()-1, instructor1);


		System.out.println(instructorManager.findById(1).getName());

		for(Instructor instructor :instructorManager.getInstructors()) {
			System.out.println(instructor.getName());
		}


		Course course1 = new Course(1, "Java", 140);
		Course course2 = new Course(2, "Css", 110);
		Course course3 = new Course(3, "C#", -1);
		Course course4 = new Course(4, "C++", 120);

		CourseManager courseManager = new CourseManager(new JdbcCourseDao(),loggers);

		courseManager.add(course1);
		courseManager.add(course3);




	}

}
