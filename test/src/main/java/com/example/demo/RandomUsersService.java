package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class RandomUsersService {
    public static List<User> getRandomStudents(){
        List<User> users = new ArrayList<>();

        users.add(new User("Andrzej", "Nowak", "32", "andrzej@nowak.pl", ""));
        users.add(new User("Jan", "Kowalski", "35", "jan@gmail.com", "Some remarks"));
        users.add(new User("John", "Blue", "14", "john@outlook.com", "Test remark!"));

        return users;
    }
}
