package user.domain;

import backup.domain.Backup;
import common.domain.BaseDomain;
import user.Activity;

import java.util.List;
import java.util.Objects;

/**
 * User domain class.
 */

public class User extends BaseDomain {

    private String name;
    private Activity activity;
    private List<Backup> listOfBackups;


    public User(String name, Long id, Activity activity, List<Backup> listOfBackups) {
        this.id = id;
        this.name = name;
        this.activity = activity;
        this.listOfBackups = listOfBackups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<Backup> getListOfBackups() {
        return listOfBackups;
    }

    public void setListOfBackups(List<Backup> listOfBackups) {
        this.listOfBackups = listOfBackups;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                activity == user.activity &&
                Objects.equals(listOfBackups, user.listOfBackups);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, activity, listOfBackups);
    }
}
