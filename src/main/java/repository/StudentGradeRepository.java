package repository;

import model.Grade;

import java.util.List;

public interface StudentGradeRepository {
    List<Grade> getAllGrade();
    String addGradeStudent(Grade grade);
    String updateGradeStudent(Grade grade);
    String removeGradeStudent(Grade grade);
    Grade findStudentGradeByMasv(String masv);
}
