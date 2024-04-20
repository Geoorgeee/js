package ru.kata.spring.boot_security.demo.model;


import javax.persistence.*;

import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "username")
    public String username;

    @Column(name = "last_name")
    public String lastname;

    @Column(name = "age")
    public byte age;


    @Column
    private String password;
    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;




    public User() {
    }

    public User(Long id, String username, String lastname, byte age) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.age = age;
    }

    public User(String username, String lastname, byte age) {
        this.username = username;
        this.lastname = lastname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public void setUsername(String name) {
        this.username = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(username, user.username) && Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, lastname, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", lastName='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }


}
