package az.coders.dto;

public class StudentDTO {
    String name;
    int id;

    public StudentDTO(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
