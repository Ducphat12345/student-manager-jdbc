package service.impl;

import model.Student;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    public StudentServiceImpl(){
        this.studentRepository = new StudentRepositoryImpl();
    }
    public List<Student> getAllStudent(){
        return studentRepository.getAllStudent();
    }

    @Override
    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public String updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public String removeStudent(Student student) {
        return studentRepository.removeStudent(student);
    }

    @Override
    public Student findStudentByMasv(String masv) {
        return studentRepository.findStudentByMasv(masv);
    }
}
