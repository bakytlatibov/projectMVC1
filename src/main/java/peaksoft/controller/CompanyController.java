package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Company;
import peaksoft.entities.Student;
import peaksoft.service.CompanyService;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final StudentService studentService;
    private final CompanyService companyService;


    @Autowired
    public CompanyController(StudentService studentService, CompanyService companyService) {
        this.studentService = studentService;
        this.companyService = companyService;

    }


    @GetMapping
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/addCompany";
    }


    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("update/{id}")
    private String updateCompany(@PathVariable("id") Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("updateCompany", company);
        return "company/updateCompany";
    }

    @PatchMapping("{id}")
    public String saveUpdateCompany(@PathVariable("id") Long id, @ModelAttribute("company") Company company) {
        companyService.updateCompany(id, company);
        return "redirect:/companies";
    }

    @DeleteMapping("/delete")
    public String deleteCompany(@RequestParam("id") Long id) {
        Company company = companyService.getCompanyById(id);
        companyService.deleteCompany(company);
        return "redirect:/companies";

    }


    @GetMapping("/students/{companyId}")
    public String getStudentsByCompany(@PathVariable("companyId") Long companyId, Model model) {
        List<Student> studentList = studentService.getStudentByCompany(companyId);
        model.addAttribute("studentList", studentList);
        model.addAttribute("count", studentList.size());
        return "company/students";
    }


}
