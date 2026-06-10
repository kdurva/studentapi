package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDTO;
import com.example.studentapi.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentDTO studentDTO);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, StudentDTO studentDTO);

    void deleteStudent(Long id);
}