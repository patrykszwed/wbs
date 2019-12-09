package com.example.demo;

import javax.validation.constraints.*;

public class User {
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    @Min(13)
    @Max(99)
    private String age;

    @Email
    private String email;

    private String remarks;

    public User(){}

    public User(@NotBlank @Size(min = 2, max = 30) String name, @NotBlank @Size String surname, @NotNull @Min(13) @Max(99) String age, @Email String email, String remarks) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
