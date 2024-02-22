package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

// class final - от этого класса нельзя наследоваться
// если final у метода - то этот метод нельзя будет переопределить
// если final у переменной - это константа, кроме некоторых случаев (например списки ArrayList<>())
public class UserView {
    private final UserController userController;
    private User user;

    public UserView(UserController userController, User user) {
        this.userController = userController;
        this.user = user;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = user.prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    User u = user.createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = user.prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    System.out.println(userController.readAll());
                    break;
                case UPDATE:
                    String userId = user.prompt("Enter user id: ");
                    userController.updateUser(userId, user.createUser());
                case DELETE:
                    String userID = user.prompt("Enter user id: ");
                    userController.deleteUser(Long.valueOf(userID));
            }
        }
    }
}
