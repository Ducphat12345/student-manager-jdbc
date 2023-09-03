package repository.impl;

import model.Grade;
import model.Student;
import repository.StudentGradeRepository;
import util.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeRepositoryImpl implements StudentGradeRepository {
    List<Grade> gradeList;
    ResultSet resultSet = null;
    public List<Grade> getAllGrade(){
        gradeList = new ArrayList<>();
        String sql = "select * from grade inner join student on student.MASV = grade.MASV";
        resultSet = JDBCHelper.excuteQuery(sql);
        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                Student student = new Student(resultSet.getString(6), resultSet.getString("hoTen"), resultSet.getString("email"), resultSet.getString("soDT"), resultSet.getBoolean("gioiTinh"), resultSet.getString("diaChi"));
                int tiengAnh = resultSet.getInt("tiengAnh");
                int tinHoc = resultSet.getInt("tinHoc");
                int gdtc = resultSet.getInt("gdtc");
                gradeList.add(new Grade(id, student, tiengAnh, tinHoc, gdtc));
            }
        }
        catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
        return gradeList;
    }

    @Override
    public String addGradeStudent(Grade grade) {
        String sql = "insert into grade(id, MASV, tiengAnh, tinHoc, gdtc) values (?, ?, ?, ?, ?)";
        int row = JDBCHelper.excuteUpdate(sql, grade.getId(), grade.getStudent().getMASV(), grade.getTiengAnh(), grade.getTinHoc(), grade.getGdtc());
        return row > 0 ? "Thêm mới thành công!" : "Thêm mới thất bại!";
    }

    @Override
    public String updateGradeStudent(Grade grade) {
        String sql = "update grade set tiengAnh = ?, tinHoc = ?, gdtc = ? where MASV = ?";
        int row = JDBCHelper.excuteUpdate(sql, grade.getTiengAnh(), grade.getTinHoc(), grade.getGdtc(), grade.getStudent().getMASV());
        return row > 0 ? "Cập nhật thành công!" : "Cập nhật thất bại!";
    }

    @Override
    public String removeGradeStudent(Grade grade) {
        String sql = "delete from grade where MASV = ?";
        int row = JDBCHelper.excuteUpdate(sql, grade.getStudent().getMASV());
        return row > 0 ? "Xóa thành công!" : "Xóa thất bại!";
    }

    @Override
    public Grade findStudentGradeByMasv(String masv) {
        String sql = "select * from grade inner join student on grade.MASV = student.MASV where grade.MASV = ?";
        resultSet = JDBCHelper.excuteQuery(sql, masv);
        try {
            while (resultSet.next()){
                int ID = resultSet.getInt("id");
                Student student = new Student(resultSet.getString(6), resultSet.getString("hoTen"), resultSet.getString("email"), resultSet.getString("soDT"), resultSet.getBoolean("gioiTinh"), resultSet.getString("diaChi"));
                int tiengAnh = resultSet.getInt("tiengAnh");
                int tinHoc = resultSet.getInt("tinHoc");
                int gdtc = resultSet.getInt("gdtc");
                Grade grade = new Grade(ID, student, tiengAnh, tinHoc, gdtc);
                return grade;
            }
        }
        catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
        return null;
    }
}
