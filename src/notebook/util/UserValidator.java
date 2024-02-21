package notebook.util;

import notebook.model.User;

public class UserValidator {
    public User validate (User user) {
        if (!isValid(user))
            throw new IllegalArgumentException("Введены некорректные данные");
//        if (user.getFirstName().isEmpty())
//            throw new IllegalArgumentException("Имя не должно быть пустым");
//        if (user.getLastName().isEmpty())
//            throw new IllegalArgumentException("Фамилия не должна быть пустым");
//        if (user.getPhone().isEmpty())
//            throw new IllegalArgumentException("Телефон не может быть пустым");
        user.setFirstName(user.getFirstName().replaceAll(" ", "").trim()); // trim() - чистит пробелы в начале и в конце строки
        user.setLastName(user.getLastName().replaceAll(" ", "").trim());
        user.setPhone(user.getPhone().replaceAll(" ", "").trim());
        return user;
    }

    private boolean isValid(User user) {
        return !user.getFirstName().isEmpty()
                || !user.getLastName().isEmpty()
                || !user.getPhone().isEmpty();
    }
}
