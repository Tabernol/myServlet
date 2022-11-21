package service;

import model.Student;
import repo.DataSource;
import repo.StudentRepo;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    StudentRepo studentRepo;   //I know need Interface

    public StudentService() {
        this.studentRepo = new StudentRepo();
    }

    public List<Student> getStudents(){
        try {
            return studentRepo.getStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
