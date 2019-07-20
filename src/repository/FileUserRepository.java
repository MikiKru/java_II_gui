package repository;

import model.User;
import model.enums.Role;
import repository.UserRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUserRepository implements UserRepository {
    private File file;

    public FileUserRepository() {
        // połaczenie z istniejącym plikiem
        file = new File("C:\\Users\\PROXIMO\\Desktop\\GUI\\java_gui\\src\\credentials.csv");
    }
    private List<User> users = new ArrayList<>();
    @Override
    public List<User> getAllUsers() {
        // wydobycie zawartości pliku
        try {
            Scanner file_content = new Scanner(file);
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
        System.out.println(users);
        return users;
    }
}
