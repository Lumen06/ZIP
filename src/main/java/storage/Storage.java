package storage;

import user.domain.User;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Storage of entities.
 */

public class Storage {

    public static List<User> listOfUsers = new ArrayList<>();

    public static Map<User, File> compressedBackups = new HashMap<>();

}
