import model.Grade;
import model.Student;
import model.User;
import repository.DatabaseContext;
import service.StudentGradeService;
import service.StudentService;
import service.impl.StudentGradeServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.UserServiceImpl;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    static UserServiceImpl userService = new UserServiceImpl();
    static StudentService studentService = new StudentServiceImpl();
    static StudentGradeService studentGradeService = new StudentGradeServiceImpl();
    static List<Student> students;
    static List<Grade> grades;
    public static void main(String[] args) {
        Connection connection = DatabaseContext.getConnection();
        if (connection != null){
            System.out.println("Kết nối thành công!");
            login();
        }
        else {
            System.out.println("Kết nối thất bại!");
        }
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection connection1 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV", "sa", "12345");
            /*
             statement insert
             */
//            Statement statement1 = connection1.createStatement();
//            String sqlInsert = "insert into student(MASV, hoTen, email, soDT, gioiTinh, diaChi) values (N'P04', N'david', N'david@gmail.com', '9876543210', 1, N'Canada')";
//            int row = statement1.executeUpdate(sqlInsert);
//            System.out.println(row > 0 ? "Insert Successfully!" : "Insert Fail!");
            /*
             statement update
            */
//            Statement statement2 = connection1.createStatement();
//            String sqlUpdate = "update student set hoTen = N'Lê Văn C', gioiTinh = 0 where MASV = N'P03'";
//            int row1 = statement2.executeUpdate(sqlUpdate);
//            System.out.println(row1 > 0 ? "Update Successfully!" : "Update Fail!");
            /*
             statement delete
            */
//            Statement statement3 = connection1.createStatement();
//            String sqlDelete = "delete from student where MASV = N'P04'";
//            int row2 = statement3.executeUpdate(sqlDelete);
//            System.out.println(row2 > 0 ? "Delete Successfully!" : "Delete Fail!");
            /*
             statement select
            */
//            Statement statement = connection1.createStatement();
//            String sqlSelect = "select * from student";
//            ResultSet resultSet = statement.executeQuery(sqlSelect);
//            while (resultSet.next()){
//                String MASV = resultSet.getString("MASV");
//                String hoTen = resultSet.getString("hoTen");
//                String email = resultSet.getString("email");
//                String soDT = resultSet.getString("soDT");
//                boolean gioiTinh = resultSet.getBoolean("gioiTinh");
//                String diaChi = resultSet.getString("diaChi");
//                System.out.println(MASV + " " + hoTen + " " + email + " " + soDT + " " + gioiTinh + " " + diaChi);
//            }
            /*
             preparedstatement insert
             */
//            String sqlInsert = "insert into student(MASV, hoTen, email, soDT, gioiTinh, diaChi) values (?, ?, ?, ?, ?, ?)";
//            PreparedStatement preparedStatement = connection1.prepareStatement(sqlInsert);
//            preparedStatement.setString(1, "P04");
//            preparedStatement.setString(2, "David");
//            preparedStatement.setString(3, "david@gmail.com");
//            preparedStatement.setString(4,"9876543210");
//            preparedStatement.setBoolean(5, true);
//            preparedStatement.setString(6, "Canada");
//            int row = preparedStatement.executeUpdate();
//            System.out.println(row > 0 ? "Insert Successfully!" : "Insert Fail!");
            /*
             preparedstatement update
             */
//            String sqlUpdate = "update student set hoTen = ?, gioiTinh = ? where MASV = ?";
//            PreparedStatement preparedStatement1 = connection1.prepareStatement(sqlUpdate);
//            preparedStatement1.setString(1, "J.David");
//            preparedStatement1.setBoolean(2, false);
//            preparedStatement1.setString(3, "P04");
//            int row1 = preparedStatement1.executeUpdate();
//            System.out.println(row1 > 0 ? "Update Successfully!" : "Update Fail!");
            /*
             preparedstatement delete
             */
//            String sqlDelete = "delete from student where MASV = ?";
//            PreparedStatement preparedStatement2 = connection1.prepareStatement(sqlDelete);
//            preparedStatement2.setString(1, "P04");
//            int row2 = preparedStatement2.executeUpdate();
//            System.out.println(row2 > 0 ? "Delete Successfully!" : "Delete Fail!");
            /*
             preparedstatement select
             */
//            String sqlSelect = "select * from student";
//            PreparedStatement preparedStatement3 = connection1.prepareStatement(sqlSelect);
//            ResultSet resultSet = preparedStatement3.executeQuery();
//            while (resultSet.next()){
//                String MASV = resultSet.getString("MASV");
//                String hoTen = resultSet.getString("hoTen");
//                String email = resultSet.getString("email");
//                String soDT = resultSet.getString("soDT");
//                boolean gioiTinh = resultSet.getBoolean("gioiTinh");
//                String diaChi = resultSet.getString("diaChi");
//                System.out.println(MASV + " " + hoTen + " " + email + " " + soDT + " " + gioiTinh + " " + diaChi);
//            }
//        }
//        catch (SQLException sqlException){
//            throw new RuntimeException(sqlException);
//        }
//        catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
    public static void login(){
        boolean check;
        do {
            System.out.println("Nhập username:");
            String username = new Scanner(System.in).nextLine();
            System.out.println("Nhập password:");
            String password = new Scanner(System.in).nextLine();
            User user = userService.getUserByUsername(username);
            if (user != null && user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                if (user.getRole().equalsIgnoreCase("giảng viên")){
                    System.out.println("Đăng nhập thành công với quyền " + user.getRole());
                    while (true){
                        studentGradeManagement();
                        System.out.println("Mời bạn chọn chương trình:");
                        int choose = new Scanner(System.in).nextInt();
                        switch (choose){
                            case 1:
                                addGradeStudentFromInput();
                                break;
                            case 2:
                                updateGradeStudentFromInput();
                                break;
                            case 3:
                                removeGradeStudentFromInput();
                                break;
                            case 4:
                                findStudentGradeByMasv();
                                break;
                            case 5:
                                getAllStudentGrade();
                                break;
                            case 6:
                                System.out.println("Kết thúc chương trình!");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Không có chương trình bạn chọn! Nhập lại:");
                                break;
                        }
                    }
                }
                else {
                    System.out.println("Đăng nhập thành công với quyền " + user.getRole());
                    while (true){
                        studentManagement();
                        System.out.println("Mời bạn chọn chương trình:");
                        int choose = new Scanner(System.in).nextInt();
                        switch (choose){
                            case 1:
                                addStudentFromInput();
                                break;
                            case 2:
                                updateStudentFromInput();
                                break;
                            case 3:
                                removeStudentFromInput();
                                break;
                            case 4:
                                findStudentByMasv();
                                break;
                            case 5:
                                getAllStudent();
                                break;
                            case 6:
                                System.out.println("Kết thúc chương trình!");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Không có chương trình bạn chọn! Nhập lại:");
                                break;
                        }
                    }
                }
            }
            else {
                System.out.println("Sai tên đăng nhập hoặc mật khẩu! Nhập lại:");
                check = true;
            }
        }
        while (check);
    }
    public static void studentManagement(){
        System.out.println("---------Menu---------");
        System.out.println("1. Thêm mới sinh viên");
        System.out.println("2. Cập nhật sinh viên");
        System.out.println("3. Xóa sinh viên");
        System.out.println("4. Tìm kiếm sinh viên");
        System.out.println("5. Hiển thị danh sách sinh viên");
        System.out.println("6. Thoát chương trình");

    }
    public static void getAllStudent(){
        students = studentService.getAllStudent();
        if (students != null){
            System.out.println("Danh sách sinh viên là:");
            students.forEach(System.out::println);
        }
        else {
            System.out.println("Không có bản ghi nào!");
        }
    }
    public static void addStudentFromInput(){
        Student student = new Student();
        while (true){
            System.out.println("Nhập mã sinh viên:");
            student.setMASV(new Scanner(System.in).nextLine());
            if (!student.getMASV().equalsIgnoreCase("")){
                break;
            }
            else {
                System.out.println("Mã sinh viên không được để trống, nhập lại!");
            }
        }
        while (true){
            System.out.println("Nhập tên sinh viên:");
            student.setHoTen(new Scanner(System.in).nextLine());
            String pattern = "[a-zA-Z ]+";
            if (!student.getHoTen().equalsIgnoreCase("") && student.getHoTen().matches(pattern)){
                break;
            }
            else {
                System.out.println("Tên không được để trống và tên chỉ là chữ, nhập lại!");
            }
        }
        while (true){
            System.out.println("Nhập email sinh viên:");
            student.setEmail(new Scanner(System.in).nextLine());
            String pattern = "\\w+@\\w+\\.\\w+";
            if (!student.getEmail().equalsIgnoreCase("") && student.getEmail().matches(pattern)){
                break;
            }
            else {
                System.out.println("Email không đúng định dạng và không đướ để trống, nhập lại!");
            }

        }
        while (true){
            System.out.println("Nhập sđt sinh viên:");
            student.setSoDT(new Scanner(System.in).nextLine());
            String pattern = "0[0-9]{9,10}";
            if (!student.getSoDT().equalsIgnoreCase("") && student.getSoDT().matches(pattern)){
                break;
            }
            else {
                System.out.println("Số điện thoại không hợp lệ, nhâp lại!");
            }
        }
        System.out.println("Nhập giới tính sinh viên:");
        student.setGioiTinh(new Scanner(System.in).nextBoolean());
        while (true){
            System.out.println("Nhập địa chỉ sinh viên:");
            student.setDiaChi(new Scanner(System.in).nextLine());
            if (!student.getDiaChi().equalsIgnoreCase("")){
                break;
            }
            else {
                System.out.println("Địa chỉ không được để trống, nhập lại!");
            }
        }
        String result = studentService.addStudent(student);
        System.out.println(result);
    }
    public static void updateStudentFromInput(){
        System.out.println("Nhập mã sinh viên muốn cập nhật:");
        String MASV = new Scanner(System.in).nextLine();
        Student student = studentService.findStudentByMasv(MASV);
        if (student != null){
            while (true){
                System.out.println("Nhập email sinh viên:");
                student.setEmail(new Scanner(System.in).nextLine());
                String pattern = "\\w+@\\w+\\.\\w+";
                if (!student.getEmail().equalsIgnoreCase("") && student.getEmail().matches(pattern)){
                    break;
                }
                else {
                    System.out.println("Email không đúng định dạng và không đướ để trống, nhập lại!");
                }

            }
            while (true){
                System.out.println("Nhập sđt sinh viên:");
                student.setSoDT(new Scanner(System.in).nextLine());
                String pattern = "0[0-9]{9,10}";
                if (!student.getSoDT().equalsIgnoreCase("") && student.getSoDT().matches(pattern)){
                    break;
                }
                else {
                    System.out.println("Số điện thoại không hợp lệ, nhâp lại!");
                }
            }
            while (true){
                System.out.println("Nhập địa chỉ sinh viên:");
                student.setDiaChi(new Scanner(System.in).nextLine());
                if (!student.getDiaChi().equalsIgnoreCase("")){
                    break;
                }
                else {
                    System.out.println("Địa chỉ không được để trống, nhập lại!");
                }
            }
            String result = studentService.updateStudent(student);
            System.out.println(result);
        }
        else {
            System.out.println("Không tìm thấy sinh viên mang mã " + MASV);
        }
    }
    public static void removeStudentFromInput(){
        System.out.println("Nhập mã sinh viên muốn xóa:");
        String MASV = new Scanner(System.in).nextLine();
        Student student = studentService.findStudentByMasv(MASV);
        if (student != null){
            String result = studentService.removeStudent(student);
            System.out.println(result);
        }
        else {
            System.out.println("Không tìm thấy sinh viên mang mã " + MASV);
        }
    }
    public static void findStudentByMasv(){
        System.out.println("Nhập mã sinh viên muốn tìm kiếm:");
        String masv = new Scanner(System.in).nextLine();
        Student student = studentService.findStudentByMasv(masv);
        if (student != null){
            System.out.println("Sinh viên tìm thấy là: " + student);
        }
        else {
            System.out.println("Không tìm thấy sinh viên mang mã " + masv);
        }
    }
    public static void studentGradeManagement(){
        System.out.println("------------Menu------------");
        System.out.println("1. Thêm điểm cho sinh viên");
        System.out.println("2. Cập nhật điểm cho sinh viên");
        System.out.println("3. Xóa điểm sinh viên");
        System.out.println("4. Tìm kiếm sinh viên");
        System.out.println("5. Hiển thị danh sách điểm sinh viên");
        System.out.println("6. Thoát chương trình");

    }
    public static void getAllStudentGrade(){
        grades = studentGradeService.getAllGrade();
        if (grades != null){
            System.out.println("Danh sách điểm sinh viên là:");
            grades.forEach(System.out::println);
        }
        else {
            System.out.println("Không có bản ghi nào!");
        }
    }
    public static void addGradeStudentFromInput(){
        Grade grade = new Grade();
        System.out.println("Nhập mã sinh viên muốn thêm điểm:");
        String MASV = new Scanner(System.in).nextLine();
        Student student = studentService.findStudentByMasv(MASV);
        if (student != null){
            System.out.println("Nhập id:");
            grade.setId(new Scanner(System.in).nextInt());
            grade.setStudent(student);
            while (true){
                System.out.println("Nhập điểm tiếng anh cho sinh viên:");
                grade.setTiengAnh(new Scanner(System.in).nextInt());
                if (grade.getTiengAnh() < 0 || grade.getTiengAnh() > 10){
                    System.out.println("Điểm phải lớn hơn 0 và nhỏ hơn 10, nhập lại!");
                }
                else {
                    break;
                }
            }
            while (true){
                System.out.println("Nhập điểm tin học cho sinh viên:");
                grade.setTinHoc(new Scanner(System.in).nextInt());
                if (grade.getTinHoc() < 0 || grade.getTinHoc() > 10){
                    System.out.println("Điểm phải lớn hơn 0 và nhỏ hơn 10, nhập lại!");
                }
                else {
                    break;
                }
            }
            while (true){
                System.out.println("Nhập điểm GDTC cho sinh viên:");
                grade.setGdtc(new Scanner(System.in).nextInt());
                if (grade.getGdtc() < 0 || grade.getGdtc() > 10){
                    System.out.println("Điểm phải lớn hơn 0 và nhỏ hơn 10, nhập lại!");
                }
                else {
                    break;
                }
            }
            String result = studentGradeService.addGradeStudent(grade);
            System.out.println(result);
        }
        else {
            System.out.println("Không tìm thấy sinh viên mang mã " + MASV);
        }
    }
    public static void updateGradeStudentFromInput(){
        System.out.println("Nhập mã sinh viên muốn cập nhật điểm:");
        String MASV = new Scanner(System.in).nextLine();
        Grade grade = studentGradeService.findStudentGradeByMasv(MASV);
        if (grade != null){
            while (true){
                System.out.println("Cập nhật điểm tiếng anh cho sinh viên:");
                grade.setTiengAnh(new Scanner(System.in).nextInt());
                if (grade.getTiengAnh() < 0 || grade.getTiengAnh() > 10){
                    System.out.println("Điểm phải lớn hơn 0 và nhỏ hơn 10, nhập lại!");
                }
                else {
                    break;
                }
            }
            while (true){
                System.out.println("Cập nhật điểm tin học cho sinh viên:");
                grade.setTinHoc(new Scanner(System.in).nextInt());
                if (grade.getTinHoc() < 0 || grade.getTinHoc() > 10){
                    System.out.println("Điểm phải lớn hơn 0 và nhỏ hơn 10, nhập lại!");
                }
                else {
                    break;
                }
            }
            while (true) {
                System.out.println("Cập nhật điểm gdtc cho sinh viên:");
                grade.setGdtc(new Scanner(System.in).nextInt());
                if (grade.getGdtc() < 0 || grade.getGdtc() > 10){
                    System.out.println("Điểm phải lớn hơn 0 và nhỏ hơn 10, nhập lại!");
                }
                else {
                    break;
                }
            }
            String result = studentGradeService.updateGradeStudent(grade);
            System.out.println(result);
        }
        else {
            System.out.println("Không tìm thấy sinh viên mang mã " + MASV);
        }
    }
    public static void removeGradeStudentFromInput(){
        System.out.println("Nhập mã sinh viên muốn xóa:");
        String MASV = new Scanner(System.in).nextLine();
        Grade grade = studentGradeService.findStudentGradeByMasv(MASV);
        if (grade != null){
            String result = studentGradeService.removeGradeStudent(grade);
            System.out.println(result);
        }
        else {
            System.out.println("Không tìm thấy sinh viên mang mã " + MASV);
        }
    }
    public static void findStudentGradeByMasv(){
        System.out.println("Nhập mã sinh viên muốn tìm kiếm:");
        String masv = new Scanner(System.in).nextLine();
        Grade grade = studentGradeService.findStudentGradeByMasv(masv);
        if (grade != null){
            System.out.println("Sinh tìm thấy là: " + grade);
        }
        else {
            System.out.println("Không tìm thấy sinh viên mang mã " + masv);
        }
    }
}
