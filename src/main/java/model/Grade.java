package model;

public class Grade {
    private int id;
    private Student student;
    private int tiengAnh;
    private int tinHoc;
    private int gdtc;
    public Grade(){}
    public Grade(int id, Student student, int tiengAnh, int tinHoc, int gdtc){
        this.id = id;
        this.student = student;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGdtc() {
        return gdtc;
    }

    public void setGdtc(int gdtc) {
        this.gdtc = gdtc;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", " + student +
                ", tiengAnh=" + tiengAnh +
                ", tinHoc=" + tinHoc +
                ", gdtc=" + gdtc +
                '}';
    }
}

