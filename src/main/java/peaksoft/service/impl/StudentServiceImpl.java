package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.dao.StudentDao;
import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public void addStudent(Long groupId, Student student) {
        studentDao.addStudent(groupId, student);

    }

    @Override
    public void updateStudent(Long groupId,Long studentId, Student student) {
        studentDao.updateStudent(groupId,studentId, student);


    }

    @Override
    public void deleteStudent(Student student) {

        studentDao.deleteStudent(student);

    }

    @Override
    public List<Student> getStudentByCompany(Long companyId) {
        return studentDao.getStudentsByCompany(companyId);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentDao.getStudentByName(name);
    }

    @Override
    public List<Student> getStudentsByTeacher(Long teacherId) {

        return studentDao.getStudentsByTeacher(teacherId);
    }

}
