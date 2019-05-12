package application;

import backup.domain.Backup;
import org.apache.log4j.Logger;
import user.Activity;
import user.domain.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
* Storage initialization class.
*/

import static storage.Storage.listOfUsers;

public class StorageInitializer {

    private static final Logger logger = Logger.getLogger(StorageInitializer.class.getName());


    public StorageInitializer() {
        storageInitialize();
    }

    private void storageInitialize() {
        listOfUsers = userInitialize();
    }

    private List<User> userInitialize() {

        List<User> users = new ArrayList<>();

        users.add(new User("Kolya", 1L, Activity.INACTIVE, backupInitialize(0)));
        users.add(new User("Vasya", 2L, Activity.INACTIVE, backupInitialize(5)));
        users.add(new User("Petya", 3L, Activity.INACTIVE, backupInitialize(100)));
        users.add(new User("Olya", 4L, Activity.INACTIVE, backupInitialize(40)));
        users.add(new User("Nastya", 5L, Activity.INACTIVE, backupInitialize(20)));

        return users;
    }

    /**
     * Method initializing list of user's backups.
     *
     * @param compressionFactor - a factor that indicates how much the file should be compressed/
     * @return list of user's backups.
     */

    private List<Backup> backupInitialize(int compressionFactor)  {

        List<Backup> userBackups = new ArrayList<>();
        try {
            switch (compressionFactor) {

                case 0: {
                    addBackupToTheList(userBackups, "non_compressible" );
                    break;
                }
                case 5: {
                    addBackupToTheList(userBackups, "x5");
                    break;
                }
                case 10: {
                    addBackupToTheList(userBackups, "x10");
                    break;
                }
                case 20: {
                    addBackupToTheList(userBackups, "x20");
                    break;
                }
                case 40: {
                    addBackupToTheList(userBackups, "x40");
                    break;
                }
                case 100: {
                    addBackupToTheList(userBackups, "x100");
                    break;
                }

            }
        }   catch (Exception e) {
            logger.error("Something wrong with backup initializing");
            e.printStackTrace();
        }

        return userBackups;
    }

    private void addBackupToTheList(List<Backup> backupList, String directoryName) {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        for (long i = 1; i<4; i++) {
            backupList.add(new Backup(i, new File(classLoader.getResource(
                    directoryName + "/" + i + ".dat").getFile()))); //reading a file from resources 1 to 3

        }

    }
}
