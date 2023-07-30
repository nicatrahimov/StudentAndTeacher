package az.coders.service;

import az.coders.config.DBConfig;
import az.coders.model.Student;
import az.coders.model.Teacher;
import az.coders.repository.StudentRepository;
import az.coders.repository.TeacherRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class InterfaceLogin {

    public void loginPage() throws SQLException {
        System.out.println("1.Qeydiyyatdan kec");
        System.out.println("2. Hazirdaki muellim ve telebeleri gormek ucun daxil olun");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.equalsIgnoreCase("1")){
            System.out.println("1.Telebe");
            System.out.println("2.Muellim");
            String ss = sc.nextLine();
            if (ss.equalsIgnoreCase("1")){
                StudentRepository sr = new StudentRepository(DBConfig.getConnection());
                Student student = sr.addStudent();
            } else if (ss.equalsIgnoreCase("2")) {
                TeacherRepository tr = new TeacherRepository(DBConfig.getConnection());
                Teacher teacher =  tr.addTeacher();
            }
        }


    }

}
