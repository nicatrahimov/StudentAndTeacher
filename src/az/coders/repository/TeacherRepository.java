package az.coders.repository;

import az.coders.enums.StateEnum;
import az.coders.exceptions.IDNotFound;
import az.coders.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRepository implements TeacherRepositoryINT {

    private final Connection connection;

    public TeacherRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Teacher getTeacherByID(int id) throws SQLException {
        Teacher teacher = new Teacher();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM teacher where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (rs.getInt("id") == id) {
                teacher.setName(rs.getString("name"));
                teacher.setSurname(rs.getString("surname"));
                teacher.setId(rs.getInt("id"));
                teacher.setAddress(rs.getString("address"));
                teacher.setMail(rs.getString("mail"));
                teacher.setCreatedAt(rs.getTimestamp("created").toLocalDateTime());
                teacher.setState(StateEnum.findByCode(rs.getInt("state")));

            }else throw new IDNotFound();
        }
        return teacher;
    }
}
