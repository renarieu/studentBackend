package com.example.studentproject.student;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;



    @Test
    void itShouldFindByName() {

        //given
        String name = "Guillhem";
        Student student = new Student(4,name);
        studentRepository.save(student);
        //when
        boolean expected = this.studentRepository.findByName(name).isPresent();

        //then
        assertTrue(expected);
    }

    @Test
    void findById() {
    }
}