package az.coders.repository;

import az.coders.enums.StateEnum;
import az.coders.exceptions.IDNotFound;
import az.coders.exceptions.TeacherCannotAdd;
import az.coders.model.Teacher;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

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

            } else throw new IDNotFound();
        }
        return teacher;
    }


    public Teacher addTeacher() throws SQLException {
        Teacher teacher = createTeacher();
        PreparedStatement ps = connection.prepareStatement("insert into teacher(name,surname,address,mail,created,state) VALUES (?,?,?,?,?,?)");
        ps.setString(1,teacher.getName());
        ps.setString(2,teacher.getSurname());
        ps.setString(3,teacher.getAddress());
        ps.setString(4,teacher.getMail());
        ps.setTimestamp(5,Timestamp.valueOf(teacher.getCreatedAt()));
        ps.setInt(6,teacher.getState().getStateCode());
        int counter = ps.executeUpdate();
        if (counter>0){
            System.out.println("Muellim ugurla elave edildi");
            return teacher;
        }else throw new TeacherCannotAdd();

    }


private Teacher createTeacher(){
        Teacher teacher = new Teacher();
    Scanner sc = new Scanner(System.in);
    System.out.println("Adini daxil edin");
    String name = sc.nextLine();
    System.out.println("Soyadi daxil edin");
    String surname = sc.nextLine();
    System.out.println("Yasadiginiz seheri qeyd edin zehmet olmasa");
    String address = sc.nextLine();
    System.out.println("Mailinizi qeyd edin");
    String mail = sc.nextLine();

    teacher.setName(name);
    teacher.setSurname(surname);
    teacher.setMail(mail);
    teacher.setCreatedAt(LocalDateTime.now());
    teacher.setState(StateEnum.ONLINE);
    teacher.setAddress(address);
    return teacher;
}
}
