package com.example.studentproject.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.studentService.getStudents();
    }

    @GetMapping("findStudent/{studentId}")
    public Student findStudent(@PathVariable String studentId){
        return this.studentService.findStudent(studentId);
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        this.studentService.addStudent(student);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable String studentId){
        this.studentService.deleteStudent(studentId);
    }

    @PutMapping("modify/{studentId}")
    public void modifyStudent(@PathVariable String studentId, @RequestBody Student student){
        this.studentService.modifyStudent(studentId, student);
    }

}
