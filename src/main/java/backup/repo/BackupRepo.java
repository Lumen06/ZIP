package backup.repo;

import dataUtils.Compressor;
import user.Activity;
import user.domain.User;

import java.io.File;
import java.util.Map;

import static storage.Storage.compressedBackups;
import static storage.Storage.listOfUsers;

/**
 * Class, containing basic operations with backup entities contained in the repository.
 */

public class BackupRepo {

    public void compressBackup() {

        listOfUsers.forEach(user -> {
            if (user.getActivity() == Activity.INACTIVE) {
                compressedBackups.put(user, compress(user));
            }
        });
    }


    private File compress(User user) {
        File generatedZip = zipFileGenerator(user);
        user.getListOfBackups().forEach(backup -> Compressor.compress(backup.getData(), generatedZip));
        return generatedZip;

    }

    private File zipFileGenerator(User user) {
        return new File(user.getId() + "_compressed_backup.zip");
    }


    public void cleanCompressedBackupsByUser(User user) {
        compressedBackups.entrySet().removeIf(entry -> compressedBackups.containsKey(user));
    }

    public void printAllCompressedBackups() {
        for (Map.Entry<User, File> map: compressedBackups.entrySet()) {
            System.out.println("User: " + map.getKey() + " Compressed backup: " + map.getValue());
        }
    }
}


