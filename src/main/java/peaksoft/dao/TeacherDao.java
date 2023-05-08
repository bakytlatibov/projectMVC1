package peaksoft.dao;

import peaksoft.entities.Student;
import peaksoft.entities.Teacher;

import javax.swing.*;
import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long teacherId);

    void addTeacher( Long teacherId,Teacher teacher);

    void updateTeacher(Long teacherId,Long courseId,Teacher teacher);

    void deleteTeacher(Teacher teacher);
}
