package az.coders.model;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import az.coders.enums.*;

public class AbstractModel {

    String mail;
    LocalDateTime created;

    StateEnum state;


    public LocalDateTime getCreatedAt() {
        return created;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.created = createdAt;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public void setMail(String mail) {
     if (checkMail(mail)){
         this.mail=mail;
     }
    }
    public boolean checkMail(String mail){
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

}
