package peaksoft.service;

import peaksoft.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long teacherId);

    void addTeacher( Long teacherId,Teacher teacher);

    void updateTeacher( Long teacherId,Long courseId,Teacher teacher);

    void deleteTeacher(Teacher teacher);
}
