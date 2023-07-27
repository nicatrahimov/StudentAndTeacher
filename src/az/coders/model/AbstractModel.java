package az.coders.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.AbstractCollection;

import az.coders.enums.*;

public class AbstractModel {
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
}
