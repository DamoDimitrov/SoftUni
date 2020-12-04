package Entities;

import orm.annotation.Column;
import orm.annotation.Entity;
import orm.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name="USERS")
public class User {
    @Id
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="pasword")
    private String pasword;
    @Column(name="age")
    private int age;
    @Column(name="registration_date")
    private LocalDate registrationDate;

    public User() {
    }

    public User(String username, String pasword, int age, LocalDate registrationDate) {
        this.username = username;
        this.pasword = pasword;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pasword='" + pasword + '\'' +
                ", age=" + age +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
