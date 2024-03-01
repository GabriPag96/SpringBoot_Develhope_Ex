package it.example.DTO_Ex.DTO;

public class StudentDTO {

    private String name;

    private String mail;

    public StudentDTO() {
    }

    public StudentDTO(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
