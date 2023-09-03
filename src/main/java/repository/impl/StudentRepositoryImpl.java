package repository.impl;

import model.Student;
import repository.StudentRepository;
import util.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    List<Student> studentList;
    ResultSet resultSet = null;
    public List<Student> getAllStudent(){
        studentList = new ArrayList<>();
        String sql = "select * from student";
        resultSet = JDBCHelper.excuteQuery(sql);
        try {
            while (resultSet.next()){
                String MASV = resultSet.getString("MASV");
                String hoTen = resultSet.getString("hoTen");
                String email = resultSet.getString("email");
                String soDT = resultSet.getString("soDT");
                boolean gioiTinh = resultSet.getBoolean("gioiTinh");
                String diaChi = resultSet.getString("diaChi");
                studentList.add(new Student(MASV, hoTen, email, soDT, gioiTinh, diaChi));
            }
        }
        catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return studentList;
    }

    @Override
    public String addStudent(Student student) {
        String sql = "insert into student(MASV, hoTen, email, soDT, gioiTinh, diaChi) values (?, ?, ?, ?, ?, ?)";
        int row = JDBCHelper.excuteUpdate(sql, student.getMASV(), student.getHoTen(), student.getEmail(), student.getSoDT(), student.isGioiTinh(), student.getDiaChi());
        return row > 0 ? "Thêm mới thành công!" : "Thêm mới thất bại!";
    }

    @Override
    public String updateStudent(Student student) {
        String sql = "update student set email = ?, soDT = ?, gioiTinh = ?, diaChi = ? where MASV = ?";
        int row = JDBCHelper.excuteUpdate(sql, student.getEmail(), student.getSoDT(), student.isGioiTinh(), student.getDiaChi(), student.getMASV());
        return row > 0 ? "Cập nhật thành công!" : "Cập nhật thất bại!";
    }

    @Override
    public String removeStudent(Student student) {
        String sql = "delete from student where MASV = ?";
        int row = JDBCHelper.excuteUpdate(sql, student.getMASV());
        return row > 0 ? "Xóa thành công!" : "Xóa thất bại!";
    }

    @Override
    public Student findStudentByMasv(String masv) {
        String sql = "select * from student where MASV = ?";
        resultSet = JDBCHelper.excuteQuery(sql, masv);
        try {
            while (resultSet.next()){
                String MASV = resultSet.getString("MASV");
                String hoTen = resultSet.getString("hoTen");
                String email = resultSet.getString("email");
                String soDT = resultSet.getString("soDT");
                boolean gioiTinh = resultSet.getBoolean("gioiTinh");
                String diaChi = resultSet.getString("diaChi");
                Student student = new Student(MASV, hoTen, email, soDT, gioiTinh, diaChi);
                return student;
            }
        }
        catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return null;
    }
}
