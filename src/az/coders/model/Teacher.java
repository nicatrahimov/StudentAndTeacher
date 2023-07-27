package az.coders.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher extends AbstractModel {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String mail;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mail);
        if (matcher.matches()) {
            this.mail = mail;
        }
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", address='" + address + '\'' + ", mail='" + mail + '\'' + ", created=" + created + ", state=" + state + '}';
    }
}
