package az.coders.repository;

import az.coders.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentRepositoryINT {
    Student getStudentById(int id) throws SQLException;
    void addStudent() throws SQLException;
}
