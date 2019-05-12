package user.repo;

import user.domain.User;

import java.util.List;
import java.util.Optional;

/**
 *  Class, containing basic operations with user entities contained in the repository.
 */

import static storage.Storage.listOfUsers;

public class UserRepo {

    public void add(User user) {
        listOfUsers.add(user);
    }

    private Optional<User> findUserById(Long id) {
        return listOfUsers.stream().filter(user -> Long.valueOf(id).equals(user.getId())).findAny();
    }

    public Optional<User> findById(Long id) {
        return findUserById(id);
    }

    public List<User> findAll() {
        return listOfUsers;
    }

    public void printAll() {
        listOfUsers.forEach(System.out::println);
    }

    public void deleteUserById( Long id) {
        Optional<User> user = findUserById(id);
        if (user != null) {
            listOfUsers.remove(user.get());
        }
    }
}
