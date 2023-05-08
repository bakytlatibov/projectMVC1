package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Course;
import peaksoft.entities.Student;
import peaksoft.entities.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.StudentService;
import peaksoft.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    private  final StudentService studentService;
    private final TeacherService teacherService;
    private  final CourseService courseService;
@Autowired
    public TeacherController(StudentService studentService, TeacherService teacherService, CourseService courseService) {
    this.studentService = studentService;
    this.teacherService = teacherService;
        this.courseService = courseService;
    }
    @ModelAttribute("courses")
    public List<Course> getCourses(){
    return courseService.getAllCourse();

    }
    @GetMapping()
    public String getAllTeachers(Model model){
    List<Teacher>teachers=teacherService.getAllTeachers();
    model.addAttribute("teachers",teachers);
    return "teacher/teachers";

    }
    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
    model.addAttribute("teacher",new Teacher());
    return "teacher/addTeacher";
    }
    @PostMapping("/saveTeacher")
public String saveTeacher(@ModelAttribute("teacher")Teacher teacher){
    teacherService.addTeacher(teacher.getCourseId(),teacher);
    return "redirect:/teachers";
}
@GetMapping("/update/{id}")
public String updateTeacher(@PathVariable("id")Long id,Model model){
    Teacher teacher=teacherService.getTeacherById(id);
    model.addAttribute("updateTeacher",teacher);
    return "teacher/updateTeacher";

}
    @PatchMapping("{id}")
    public String saveUpdateTeacher(@PathVariable("id")Long id,@ModelAttribute("teacher") Teacher teacher) {
    teacherService.updateTeacher(id, teacher.getCourseId(), teacher);
        return "redirect:/teachers";
    }
@DeleteMapping("/delete")
public String deleteTeacher(@RequestParam("id")Long id){
    Teacher teacher=teacherService.getTeacherById(id);
    teacherService.deleteTeacher(teacher);
    return "redirect:/teachers";
}
    @GetMapping("/students/{teacherId}")
    public String getStudentsByTeacher(@PathVariable("teacherId") Long teacherId, Model model){
        List<Student> studentList = studentService.getStudentsByTeacher(teacherId);
        model.addAttribute("studentList", studentList);
        model.addAttribute("count", studentList.size());
        return "teacher/students";
    }
}
