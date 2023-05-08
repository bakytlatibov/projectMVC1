package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.TeacherDao;
import peaksoft.entities.Teacher;
import peaksoft.service.TeacherService;

import java.util.List;
@Service

public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;


    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

    @Override
    public void addTeacher(Long teacherId,Teacher teacher) {
        teacherDao.addTeacher(teacherId,teacher);

    }

    @Override
    public void updateTeacher(Long teacherId,Long courseId,Teacher teacher) {
        teacherDao.updateTeacher(teacherId,courseId,teacher);

    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.deleteTeacher(teacher);

    }
}
