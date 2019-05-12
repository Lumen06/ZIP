package backup.service;

import backup.domain.Backup;
import backup.repo.BackupRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.Activity;
import user.domain.User;
import user.repo.UserRepo;
import user.service.UserService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static storage.Storage.compressedBackups;
import static storage.Storage.listOfUsers;

class BackupServiceTest {

    private UserService userService;
    private BackupService backupService;
    private User user;
    private List<Backup> backupList;


    private List<Backup> initializeListOfBackups() {

        backupList = new ArrayList<>();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        for (long i = 1; i < 36; i++) { //initialization of 36 backups from resources
            backupList.add(new Backup(i, new File(classLoader.getResource("resources/test_files/" + i + ".dat").getFile())));
        }
        return backupList;
    }

    @BeforeEach
    public void setUp() {

        userService = new UserService(new UserRepo());
        backupService = new BackupService(new BackupRepo());
        List<Backup> listOfBackups = initializeListOfBackups();
        user = new User("name", 1L, Activity.INACTIVE, listOfBackups);
        userService.add(user);

    }

    @Test
    void compressBackup() {
        backupService.compressBackup();
        assertEquals(1, compressedBackups.size());

    }

    @Test
    void cleanCompressedBackupsByUser() {
        backupService.cleanCompressedBackupsByUser(user);
        assertTrue(!compressedBackups.containsKey(user));
    }
    @AfterEach
    public void cleanStorage() {
        listOfUsers.clear();
        compressedBackups.clear();
    }



}