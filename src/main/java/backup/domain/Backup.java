package backup.domain;

import common.domain.BaseDomain;

import java.io.File;
import java.util.Objects;

/**
 * Backup domain class.
 */

public class Backup extends BaseDomain {

    private File data;

    public Backup(Long id, File data) {
        this.id = id;
        this.data = data;
    }

    public File getData() {
        return data;
    }

    public void setData(File data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backup backup = (Backup) o;
        return Objects.equals(data, backup.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data);
    }
}
