package repository;

import model.User;
import repository.UserRepository;

import java.io.File;
import java.util.List;

public class FileUserRepository implements UserRepository {
    private File file;

    public FileUserRepository() {
        // połaczenie z istniejącym plikiem
        file = new File("C:\\Users\\PROXIMO\\Desktop\\GUI\\java_gui\\src\\credentials.csv")
    }
    @Override
    public List<User> getAllUsers() {
        // ???
    }
}
