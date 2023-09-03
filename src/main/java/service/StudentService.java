package service;

import model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    String addStudent(Student student);
    String updateStudent(Student student);
    String removeStudent(Student student);
    Student findStudentByMasv(String masv);
}
