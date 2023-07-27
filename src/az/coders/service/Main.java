package az.coders.service;

import az.coders.config.DBConfig;
import az.coders.dto.StudentDTO;
import az.coders.model.Student;
import az.coders.model.Teacher;
import az.coders.repository.StudentRepository;
import az.coders.repository.TeacherRepository;

import javax.sound.midi.Soundbank;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentRepository studentRepository = new StudentRepository(DBConfig.getConnection());
        TeacherRepository teacherRepository = new TeacherRepository(DBConfig.getConnection());
        Student student = studentRepository.getStudentById(1);
        Teacher teacher =  teacherRepository.getTeacherByID(2);


        System.out.println(student);
        System.out.println(teacher);

studentRepository.addStudent();

    }
}
