package az.coders.repository;

import az.coders.model.Teacher;

import java.sql.SQLException;

@FunctionalInterface
public interface TeacherRepositoryINT {
     Teacher getTeacherByID(int id) throws SQLException;
}
