package peaksoft.service;

import peaksoft.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    void addCourse(Long companyId, Course course);

    Course getCurseById(Long id);

    void updateCourse(Long companyId, Long courseId, Course course);

    void deleteCourse(Course course);
}
