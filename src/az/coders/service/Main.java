package az.coders.service;


import az.coders.config.DBConfig;
import az.coders.model.Student;
import az.coders.model.Teacher;
import az.coders.repository.StudentRepository;
import az.coders.repository.TeacherRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        while (true) {

            System.out.println("1. Qeydiyyatdan kec");
            System.out.println("2. Hazirdaki muellim ve telebeleri gormek ucun daxil olun");
            System.out.println("3. Programdan cixis");

            Scanner sc = new Scanner(System.in);
            String firstOption = sc.nextLine();


            if (firstOption.equalsIgnoreCase("1")) {
                System.out.println("1.Telebe");
                System.out.println("2.Muellim");
                String ss = sc.nextLine();

                if (ss.equalsIgnoreCase("1")) {
                    StudentRepository sr = new StudentRepository(DBConfig.getConnection());
                    sr.addStudent();
                } else if (ss.equalsIgnoreCase("2")) {
                    TeacherRepository tr = new TeacherRepository(DBConfig.getConnection());
                    tr.addTeacher();
                }
            } else if (firstOption.equalsIgnoreCase("2")) {
                Scanner scs = new Scanner(System.in);
                System.out.println("1.Telebe");
                System.out.println("2.Muellim");
                String option = scs.nextLine();
                if (option.equalsIgnoreCase("1")){

                }




            } else if (firstOption.equalsIgnoreCase("3")) {
                break;
            }


        }
    }
}
