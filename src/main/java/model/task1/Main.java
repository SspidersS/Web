package main.java.model.task1;

import static main.java.model.User.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String newUser = "{\"name\":\"John Doe\",\"username\":\"johndoe\",\"email\":\"johndoe@example.com\"}";
        String createdUser = createUser(newUser);
        System.out.println("Created User: " + createdUser);

        String updatedUserJson = "{\"id\":1,\"name\":\"John Updated Doe\",\"username\":\"johndoe\",\"email\":\"johndoe@example.com\"}";
        String updatedUser = updateUser(1, updatedUserJson);
        System.out.println("Updated User: " + updatedUser);

        int deleteStatus = deleteUser(1);
        System.out.println("Delete status: " + deleteStatus);

        String users = getAllUsers();
        System.out.println("All Users: " + users);

        String userById = getUserById(1);
        System.out.println("User by ID: " + userById);

        String userByUsername = getUserByUsername("Bret");
        System.out.println("User by Username: " + userByUsername);
    }
}
