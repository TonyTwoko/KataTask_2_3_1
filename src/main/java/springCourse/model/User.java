package springCourse.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "минимум 2 буквы, максимум 30")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Фамилия не должна быть пустой")
    @Size(min = 2, max = 30, message = "минимум 2 буквы, максимум 30")
    @Column(name = "surname")
    private String surname;

    @Min(value = 14, message = "минимальный возраст пользователя 14 лет")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "укажите пол пользователя")
    @Email
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(int id, String name, String surname, int age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public User(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public int getId() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
