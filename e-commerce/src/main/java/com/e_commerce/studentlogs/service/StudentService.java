package com.e_commerce.studentlogs.service;


import com.e_commerce.studentlogs.model.Student;
import com.e_commerce.studentlogs.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update Student
    public Student updateStudent(Long id, Student student) {

        Student existing = studentRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setAge(student.getAge());
            return studentRepository.save(existing);
        }

        return null;
    }

    // Delete Student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
