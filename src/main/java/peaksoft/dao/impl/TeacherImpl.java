package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.TeacherDao;
import peaksoft.entities.Course;
import peaksoft.entities.Student;
import peaksoft.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class TeacherImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teacher = manager.createQuery("from Teacher", Teacher.class).getResultList();

        return teacher;
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        Teacher teacher = manager.find(Teacher.class, teacherId);


        return teacher;
    }

    @Override
    public void addTeacher(Long courseId, Teacher teacher) {
        Course course = manager.find(Course.class, courseId);
        teacher.setCourse(course);

        manager.persist(teacher);


    }

    @Override
    public void updateTeacher(Long teacherId,Long courseId, Teacher teacher) {
        Course course=manager.find(Course.class,courseId);
        Teacher teacher1 = getTeacherById(teacherId);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        course.setTeacher(teacher1);
        teacher1.setCourse(course);
        manager.merge(teacher);

    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        manager.remove(manager.contains(teacher) ? teacher : manager.merge(teacher));

    }
}
