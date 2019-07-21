package repository;

import model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();
    Optional<User> getUserByLogin(String login);
}
