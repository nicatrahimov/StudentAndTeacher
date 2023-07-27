package az.coders.service;

import az.coders.config.DBConfig;
import az.coders.dto.StudentDTO;
import az.coders.model.Student;
import az.coders.repository.StudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentRepository studentRepository = new StudentRepository(DBConfig.getConnection());
        System.out.println(studentRepository.getStudentById(2));
        Student student1 = studentRepository.getStudentById(1);
        StudentDTO studentDTO = new StudentDTO(student1.getName(),student1.getId());
        System.out.println(studentDTO);



    }
}
