package oopWithNLayeredApp.dataAccess.instructor;

import oopWithNLayeredApp.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class HibernateInstructorDao implements InstructorDao {

    private List<Instructor> instructors = new ArrayList<>();

    @Override
    public void add(Instructor instructor) {
        instructors.add(instructor);
        System.out.println("Instructor Hibernate ile veritabanına eklendi.");

    }

    @Override
    public void update(int id, Instructor instructor) {
        instructors.set(id, instructor);
        System.out.println("Instructor guncellendi.");

    }

    @Override
    public void delete(int id) {
        instructors.remove(id);
        System.out.println("Instructor silindi.");

    }

    @Override
    public Instructor getById(int id) {
        return instructors.get(id-1);
    }

    @Override
    public List<Instructor> getInstructors() {
        return instructors;
    }
}
