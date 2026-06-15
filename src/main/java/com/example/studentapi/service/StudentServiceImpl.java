package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDTO;
import com.example.studentapi.entity.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student createStudent(StudentDTO dto) {

        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setCourse(dto.getCourse());

        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Long id, StudentDTO dto) {

        Student student = repository.findById(id).orElse(null);

        if (student != null) {
            student.setName(dto.getName());
            student.setAge(dto.getAge());
            student.setCourse(dto.getCourse());

            return repository.save(student);
        }

        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}