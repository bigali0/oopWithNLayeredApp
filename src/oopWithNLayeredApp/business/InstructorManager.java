package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.instructor.InstructorDao;
import oopWithNLayeredApp.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorManager {

    private InstructorDao instructorDao;
    private List<Logger> loggers = new ArrayList<>();

    public InstructorManager(InstructorDao instructorDao, List<Logger> loggers) {
        this.instructorDao = instructorDao;
        this.loggers = loggers;
    }

    public void add(Instructor instructor) {
        instructorDao.add(instructor);

        for (Logger logger : loggers) {
            logger.log(instructor.getName());
        }
    }

    public void delete(int id) {
        instructorDao.delete(id);
    }

    public void update(int id, Instructor instructor) {
        instructorDao.update(id, instructor);
    }

    public Instructor findById(int id) {
        return instructorDao.getById(id);
    }

    public List<Instructor> getInstructors() {
        return instructorDao.getInstructors();
    }


}

