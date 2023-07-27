package az.coders.repository;

import az.coders.model.Student;

import java.sql.SQLException;

public interface StudentRepositoryINT {
    Student getStudentById(int id) throws SQLException;
}
