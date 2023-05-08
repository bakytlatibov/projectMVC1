package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private  final StudentService service;
    private final GroupService groupService;
@Autowired
    public StudentController(StudentService service, GroupService groupService) {
        this.service = service;
        this.groupService = groupService;
    }
    @ModelAttribute("groupList")
   public List<Group> getGroupList(){
    return groupService.getAllGroups();

   }
   @GetMapping()
   public String getAllStudents(Model model){
    List<Student>students=service.getAllStudents();
   model.addAttribute("students",students);
   return "student/students";
   }

@GetMapping("/addStudent")
   public String addStudent(Model model){
    model.addAttribute("student",new Student());
    return "student/addStudent";
   }
   @PostMapping("saveStudent")
   public String saveStudent(@ModelAttribute("student")Student student){
    service.addStudent(student.getGroupId(),student);
    return "redirect:/students";
   }
   @GetMapping("update/{id}")
   public  String update(@PathVariable("id")Long id,Model model){
    Student student=service.getStudentById(id);
    model.addAttribute("student",student);
    return "student/updateStudent";
   }
  @PatchMapping("{id}")
   public String saveUpdate(@PathVariable("id")Long id,@ModelAttribute("students")Student student) {
      service.updateStudent(student.getGroupId(),id, student);
      return "redirect:/students";
  }
    }





