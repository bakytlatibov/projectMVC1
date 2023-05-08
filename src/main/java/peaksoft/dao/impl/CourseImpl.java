package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CourseDao;
import peaksoft.entities.Company;
import peaksoft.entities.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional

public class CourseImpl implements CourseDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Course> getAllCourse() {
        List<Course> courses = manager.createQuery("FROM Course", Course.class).getResultList();
        return courses;
    }

    @Override
    public void addCourse(Long companyId, Course course) {
        Company company = manager.find(Company.class, companyId);
        course.setCompany(company);
        manager.persist(course);

    }

    @Override
    public Course getCurseById(Long id) {
        Course course = manager.find(Course.class, id);

        return course;
    }

    @Override
    public void updateCourse(Long companyId, Long id, Course course) {
        Company company = manager.find(Company.class, companyId);
        Course course1 = getCurseById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDurationMonth(course.getDurationMonth());
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        company.setCourse(courses);
        course1.setCompany(company);
        manager.merge(course1);


    }

    @Override
    public void deleteCourse(Course course) {
        manager.remove(manager.contains(course) ? course : manager.merge(course));

    }


}
