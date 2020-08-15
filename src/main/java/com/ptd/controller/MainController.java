package com.ptd.controller;

import com.ptd.entity.Student;
import com.ptd.model.ClassDTO;
import com.ptd.model.DepartmentDTO;
import com.ptd.model.StudentDTO;
import com.ptd.model.TeacherDTO;
import com.ptd.service.ClassService;
import com.ptd.service.DepartmentService;
import com.ptd.service.StudentSevice;
import com.ptd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    StudentSevice studentSevice;
    @Autowired
    Environment environment;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    ClassService classService;
    @Autowired
    TeacherService teacherService;

    @GetMapping("/")
    public String Home(HttpServletRequest request) {
        return "home";
    }

    @GetMapping("/qlsv")
    private String ManageStudent(HttpServletRequest request) {
        return "manage_student";
    }

    @GetMapping("/qllh")
    private String ManageClass(HttpServletRequest request) {
        return "manage_class";
    }

    @GetMapping("/qlgv")
    private String ManageTeacher(HttpServletRequest request) {
        return "manage_teacher";
    }

    @GetMapping("/dssv")
    private String ListStudent(HttpServletRequest request) {
        return "list_student";
    }

    @GetMapping("/add-student")
    private String AddStudent(HttpServletRequest request) {
        return "add_student";
    }

    @GetMapping("/add-class")
    private String AddClass(HttpServletRequest request) {
        return "add_class";
    }

    @GetMapping("/delete-class")
    private String DeleteClass(HttpServletRequest request) {
        return "delete_class";
    }

    @GetMapping("/delete-class/{classId}")
    private @ResponseBody String DeleteClassById(HttpServletRequest request, @PathVariable(name = "classId") int classId){
        classService.deleteClass(classId);
        return "{\"msg\":\"success\"}";
    }

    @GetMapping("/student-detail/{studentId}")
    private String StudentDetail(HttpServletRequest request, Model model, @PathVariable(name = "studentId") int studentId) {
        StudentDTO studentDTO = studentSevice.getStudentById(studentId);
        //request.setAttribute("student",studentDTO);
        model.addAttribute("student", studentDTO);
        return "student_details";
    }

    @PostMapping("/student-detail")
    public String updateStudent(HttpServletRequest request, @ModelAttribute(name = "student") StudentDTO studentDTO) {
        System.out.println(studentDTO.toString());
        StudentDTO studentUpdate = studentSevice.getStudentById(studentDTO.getId());

        studentUpdate.setName(studentDTO.getName());
        studentUpdate.setCountry(studentDTO.getCountry());
        studentUpdate.setDoB(studentDTO.getDoB());
        studentUpdate.setAverage(studentDTO.getAverage());

        studentSevice.updateStudent(studentUpdate);
        return "redirect:/student-detail/" + studentDTO.getId();
    }

    @RequestMapping(value = "/add-new-student", method = RequestMethod.POST)
    public @ResponseBody
    String addNewStudent(HttpServletRequest request, @RequestBody Map<String, String> json) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(json.get("name"));
        studentDTO.setDoB(json.get("doB"));
        studentDTO.setAverage(Double.parseDouble(json.get("average")));
        studentDTO.setCountry(json.get("country"));
        int classId = Integer.parseInt(json.get("class"));
        studentSevice.addStudent(studentDTO, classId);

        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "/add-new-class", method = RequestMethod.POST)
    public @ResponseBody
    String addNewClass(HttpServletRequest request, @RequestBody Map<String, String> json) {
        String className = json.get("className");
        int deparmentId = Integer.parseInt(json.get("department"));
        int teacherId = Integer.parseInt(json.get("teacher"));
        classService.addNewClass(deparmentId, teacherId, className);

        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "/delete-student/{studentId}", method = RequestMethod.GET)
    public String deleteStudent(HttpServletRequest request, @PathVariable(name = "studentId") int studentId) {
        studentSevice.deleteStudent(studentId);
        return "redirect:/dssv";
    }

    @RequestMapping(value = "/list-departments", method = RequestMethod.GET)
    private @ResponseBody
    List<DepartmentDTO> listDepartments(HttpServletRequest request) {
        List<DepartmentDTO> departments = departmentService.getAllDepartment();
        return departments;
    }

    @RequestMapping(value = "/classes/{departId}", method = RequestMethod.GET)
    public @ResponseBody
    List<ClassDTO> listClassByDeparment(HttpServletRequest request, @PathVariable(name = "departId") int departId) {
        return classService.getClassByDepartment(departId);
    }

    @RequestMapping(value = "/students/{classId}", method = RequestMethod.GET)
    public @ResponseBody
    List<StudentDTO> listStudentByDeparment(HttpServletRequest request, @PathVariable(name = "classId") int classId) {
        return studentSevice.getStudentsByClass(classId);
    }

    @RequestMapping(value = "/list-teacher/{departmentId}", method = RequestMethod.GET)
    public @ResponseBody
    List<TeacherDTO> listTeacherbyId(HttpServletRequest request, @PathVariable(name = "departmentId") int departmentId) {
        return teacherService.getTeacherByDepartment(departmentId);
    }
}
