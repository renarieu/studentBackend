package com.example.studentproject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

    public void addStudent(Student student){
//        Optional<Student> studentByName = studentRepository.findByName(student.getName());
//        if (studentByName.isPresent()){
//            this.studentRepository.save(student);
//        }
        this.studentRepository.save(student);
    }

    public void deleteStudent(String studentId){
        long parsedStudentId = Long.parseLong(studentId);
        Optional<Student> studentById = studentRepository.findById(parsedStudentId);
        if (studentById.isPresent()){
            this.studentRepository.deleteById(parsedStudentId);
        }

    }



    public void modifyStudent(String studentId, Student student){
        long parsedStudentId = Long.parseLong(studentId);
        Student newStudent = this.studentRepository.findById(parsedStudentId).orElseThrow(()-> new IllegalArgumentException());
        newStudent.setName(student.getName());
        this.studentRepository.save(newStudent);

    }


    public Student findStudent(String studentId) {
        long parsedStudentId = Long.parseLong(studentId);
        return this.studentRepository.findById(parsedStudentId).orElseThrow(()-> new IllegalArgumentException());

    }
}
