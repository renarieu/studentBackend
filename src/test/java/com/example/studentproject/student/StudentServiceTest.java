package com.example.studentproject.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @Test
    void canGetAllStudents() {
        //when
        studentService.getStudents();
        //then
        verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent() {

        //given
        String name = "Guillhem";
        Student student = new Student(4,name);

        //when
        studentService.addStudent(student);

        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();
        assert(capturedStudent.equals(student));

    }

    @Test
    @Disabled
    void deleteStudent() {
    }

    @Test
    @Disabled
    void modifyStudent() {
    }
}