package peaksoft.service;

import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.entities.User;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long studentId);

    void addStudent(Long studentId,Student student);

    void updateStudent(Long groupId,Long studentId, Student student);

    void deleteStudent(Student student);
    List<Student>getStudentByCompany(Long companyId);
    List<Student>getStudentByName(String name);
    List<Student>getStudentsByTeacher(Long teacherId);


}
