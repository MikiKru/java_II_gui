package repository;

import model.User;
import model.enums.Role;
import repository.UserRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FileUserRepository implements UserRepository {
    private File credential_file;
    private String credential_path;
    public FileUserRepository() {
        // połaczenie z istniejącym plikiem
        credential_path = this.getClass()
                .getClassLoader()
                .getResource("file/credentials.csv").getFile();
        credential_file = new File(credential_path);
    }
    private List<User> users = new ArrayList<>();
    @Override
    public List<User> getAllUsers() {
        // wydobycie zawartości pliku
        try {
            Scanner file_content = new Scanner(credential_file);
            file_content.nextLine();
            while (file_content.hasNextLine()) {
                // preprocessing pliku -> cięce po ';'
                String users_array [] = file_content.next().split(";");
                // wprowadzenie wydobytych pól z pliku do modelu
                User user = new User(users_array[0], users_array[1], Role.valueOf(users_array[2]));
                // dodanie instancji modelu do listy
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // zwrócenie listy wszystkich użytkowników
        return users;
    }
    @Override
    public Optional<User> getUserByLogin(String login) {
        return getAllUsers().stream().filter(user -> user.getLogin().equals(login)).findAny();
    }
}
