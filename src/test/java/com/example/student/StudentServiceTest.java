package com.example.student;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    public StudentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");

        when(studentRepository.findAll()).thenReturn(Collections.singletonList(student));

        List<Student> students = studentService.getAllStudents();
        assertEquals(1, students.size());
        assertEquals("John", students.get(0).getFirstName());
        assertEquals("Doe", students.get(0).getLastName());
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("campler");
        student.setEmail("jane.campler@example.com");

        when(studentRepository.save(student)).thenReturn(student);

        Student savedStudent = studentService.saveStudent(student);
        assertEquals("Jane", savedStudent.getFirstName());
        assertEquals("campler", savedStudent.getLastName());
        
    }
}
