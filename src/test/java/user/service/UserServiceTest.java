package user.service;

import backup.domain.Backup;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.Activity;
import user.domain.User;
import user.repo.UserRepo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static storage.Storage.listOfUsers;

class UserServiceTest {

    private UserService userService;
    private User user;
    private List<Backup> listOfBackup;

    @BeforeEach
    public void setUp() {

        listOfBackup = new ArrayList<>();
        listOfBackup.add(new Backup(1L, new File("1.txt")));
        listOfBackup.add(new Backup(1L, new File("2.txt")));
        userService = new UserService(new UserRepo());
        user = new User("Vasya", 1L, Activity.INACTIVE, listOfBackup);

    }

    @Test
    void add() {
        userService.add(user);
        assertEquals(1, listOfUsers.size());
    }

    @Test
    void findUserById() {
        userService.add(user);
        Optional<User> foundedUser = userService.findById(user.getId());
        assertEquals(user, foundedUser.get());
    }

    @Test
    void deleteUserById() {
        userService.add(user);
        userService.deleteUserById(user.getId());
        assertEquals(0, listOfUsers.size());
    }

    @AfterEach
    public void cleanStorage() {
        listOfUsers.clear();
    }
}