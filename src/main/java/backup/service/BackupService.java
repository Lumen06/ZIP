package backup.service;

import backup.repo.BackupRepo;
import user.domain.User;

/**
 * A service that allows you to compress user backups.
 * Also contains basic operations of working with backups.
 */

public class BackupService extends BackupRepo {

    private BackupRepo backupRepo;

    public BackupService(BackupRepo backupRepo) {
        this.backupRepo = backupRepo;
    }

    @Override
    public void compressBackup() {
        backupRepo.compressBackup();
    }

    @Override
    public void cleanCompressedBackupsByUser(User user) {
        if (user != null) {
            backupRepo.cleanCompressedBackupsByUser(user);
        }
    }

    @Override
    public void printAllCompressedBackups() {
        backupRepo.printAllCompressedBackups();
    }
}
