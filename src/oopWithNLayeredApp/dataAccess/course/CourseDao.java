package oopWithNLayeredApp.dataAccess.course;

import oopWithNLayeredApp.entities.Course;

import java.util.List;

public interface CourseDao {

    void add(Course course);

    void update(int id, Course course);

    void delete(int id);

    Course getById(int id);

    List<Course> getCourses();

}
