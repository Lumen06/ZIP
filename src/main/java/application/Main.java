package application;


import user.Activity;
import user.domain.User;
import user.repo.UserRepo;
import user.service.UserService;

import java.util.ArrayList;

import static storage.Storage.listOfUsers;

public class Main {

    public static void main(String[] args) {

        //new ZipFactory();
        UserService userService = new UserService(new UserRepo());
        listOfUsers.add(new User("name", 1L, Activity.INACTIVE, new ArrayList<>()));
        userService.printAll();
        userService.deleteUserById(1L);
        userService.printAll();

    }
}
