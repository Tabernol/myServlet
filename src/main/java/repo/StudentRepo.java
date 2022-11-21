package repo;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {
    public Student getStudentById(int id) throws SQLException {
        String SQL_QUERY = "select * from student_test where id_student = " + id;
        Student student = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                student = new Student();
                student.setIdStudent(rs.getInt("id_student"));
                student.setNameStudent(rs.getString("name_student"));
            }
        }
        return student;
    }

    public List<Student> getStudents() throws SQLException {
        String SQL_QUERY = "select * from student_test";
        List<Student> students = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery();) {
            students = new ArrayList<>();
            Student student;
            while (rs.next()) {
                student = new Student();
                student.setIdStudent(rs.getInt("id_student"));
                student.setNameStudent(rs.getString("name_student"));
                students.add(student);
            }
        }
        return students;
    }

//    public static void main(String[] args) {
//    StudentRepo studentRepo = new StudentRepo();
//    List<Student> students;
//        try {
//            students = studentRepo.getStudents();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(students);
//    }
}
