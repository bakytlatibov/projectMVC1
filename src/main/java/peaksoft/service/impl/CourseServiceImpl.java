package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.CourseDao;
import peaksoft.entities.Course;
import peaksoft.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao;

    @Autowired

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void addCourse(Long companyId, Course course) {
        courseDao.addCourse(companyId, course);
    }

    @Override
    public Course getCurseById(Long id) {

        return courseDao.getCurseById(id);
    }

    @Override
    public void updateCourse(Long companyId, Long courseId, Course course) {
        courseDao.updateCourse(companyId, courseId, course);

    }

    @Override
    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);


    }
}
