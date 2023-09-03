package service.impl;

import model.Grade;
import repository.StudentGradeRepository;
import repository.impl.StudentGradeRepositoryImpl;
import service.StudentGradeService;

import java.util.List;

public class StudentGradeServiceImpl implements StudentGradeService {
    private StudentGradeRepository studentGradeRepository;

    public StudentGradeServiceImpl() {
        this.studentGradeRepository = new StudentGradeRepositoryImpl();
    }
    public List<Grade> getAllGrade(){
        return studentGradeRepository.getAllGrade();
    }

    @Override
    public String addGradeStudent(Grade grade) {
        return studentGradeRepository.addGradeStudent(grade);
    }

    @Override
    public String updateGradeStudent(Grade grade) {
        return studentGradeRepository.updateGradeStudent(grade);
    }

    @Override
    public String removeGradeStudent(Grade grade) {
        return studentGradeRepository.removeGradeStudent(grade);
    }

    @Override
    public Grade findStudentGradeByMasv(String masv) {
        return studentGradeRepository.findStudentGradeByMasv(masv);
    }
}
