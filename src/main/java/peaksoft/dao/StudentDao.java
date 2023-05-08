package peaksoft.dao;

import peaksoft.entities.Student;
import peaksoft.entities.User;

import javax.swing.event.ListDataEvent;
import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();

    Student getStudentById(Long studentId);

    void addStudent( Long group,Student student);

    void updateStudent(Long groupId,Long studentId, Student student);

    void deleteStudent(Student student);
    List<Student>getStudentsByCompany(Long companyId);
    List<Student>getStudentByName(String name);
    List<Student>getStudentsByTeacher(Long teacherId);

}
