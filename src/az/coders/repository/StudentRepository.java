package az.coders.repository;

import az.coders.enums.StateEnum;
import az.coders.exceptions.IDNotFound;
import az.coders.exceptions.StudentCannotAdd;
import az.coders.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

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
        if (rs.next()) {
            if (rs.getInt("id") == id) {
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setId(rs.getInt("id"));
                student.setAddress(rs.getString("address"));
                student.setMail(rs.getString("mail"));
                student.setCreatedAt(rs.getTimestamp("created").toLocalDateTime());
                student.setState(StateEnum.findByCode(rs.getInt("state")));
            }
        } else throw new IDNotFound();
        return student;
    }

    public Student addStudent() throws SQLException {
        Student student = createStudent();
        PreparedStatement ps = connection.prepareStatement("insert into student(name,surname,address,mail,created,state) VALUES(?,?,?,?,?,?)");
        ps.setString(1, student.getName());
        ps.setString(2, student.getSurname());
        ps.setString(3, student.getAddress());
        ps.setString(4, student.getMail());
        ps.setObject(5, java.sql.Timestamp.valueOf(student.getCreatedAt()));
        ps.setInt(6, student.getState().getStateCode());
        int ff = ps.executeUpdate();
        if (ff > 0) {
            System.out.println("Sagird ugurla qeydiyyatdan kecirildi");
            return student;
        } else throw new StudentCannotAdd();
    }

    private Student createStudent() {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("Adini daxil edin");
        String name = sc.nextLine();
        System.out.println("Soyadi daxil edin");
        String surname = sc.nextLine();
        System.out.println("Yasadiginiz seheri qeyd edin zehmet olmasa");
        String address = sc.nextLine();
        System.out.println("Mailinizi qeyd edin");
        String mail = sc.nextLine();
        student.setName(name);
        student.setSurname(surname);
        student.setMail(mail);
        student.setCreatedAt(LocalDateTime.now());
        student.setState(StateEnum.ONLINE);
        student.setAddress(address);
        System.out.println(student);

        return student;
    }
}