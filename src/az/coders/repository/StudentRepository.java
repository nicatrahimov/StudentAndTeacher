package az.coders.repository;

import az.coders.enums.StateEnum;
import az.coders.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepository implements StudentRepositoryINT {

    private final Connection connection;

    public StudentRepository(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        Student student = new Student();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM student where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            student.setAddress(rs.getString("address"));
            student.setMail(rs.getString("mail"));
            student.setCreatedAt(rs.getTimestamp("created").toLocalDateTime());
            student.setState(StateEnum.findByCode(rs.getInt("state")));
        }
        return student;
    }
}
