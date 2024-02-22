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
        System.out.println("Press 0 to call EXIT\n1 - CREATE\n2 - READ\n3 - LIST\n4 - UPDATE\n5 - DELETE");

        while (true) {
            String com = user.prompt("Введите команду: ");
            if (com.equals("0")) return;
            switch (com) {
                case "1":
                    User u = user.createUser();
                    userController.saveUser(u);
                    break;
                case "2":
                    String id = user.prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    System.out.println(userController.readAll());
                    break;
                case "4":
                    String userId = user.prompt("Enter user id: ");
                    userController.updateUser(userId, user.createUser());
                case "5":
                    String userID = user.prompt("Enter user id: ");
                    userController.deleteUser(Long.valueOf(userID));
            }
        }
    }
}
