package oopWithNLayeredApp.dataAccess.instructor;

import oopWithNLayeredApp.entities.Instructor;

import java.util.List;

public interface InstructorDao {
    void add(Instructor instructor);

    void update(int id, Instructor instructor);

    void delete(int id);

    Instructor getById(int id);

    List<Instructor> getInstructors();
}
