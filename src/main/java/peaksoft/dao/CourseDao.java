package peaksoft.dao;

import peaksoft.entities.Company;
import peaksoft.entities.Course;

import java.util.List;
import java.util.LongSummaryStatistics;

public interface CourseDao {
    List<Course> getAllCourse();
    void  addCourse(Long companyId, Course course);
    Course getCurseById(Long id);
    void updateCourse(Long companyId,Long courseId,Course course);
    void deleteCourse(Course course);


}
