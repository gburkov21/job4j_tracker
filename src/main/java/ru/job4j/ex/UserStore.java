package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("user '" + login + "' is not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("User '" + user.getUsername() + "' is not valid");
        }

        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("User '" + user.getUsername() + "' length less than 3 symbols");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ex) {
            ex.printStackTrace();
        } catch (UserNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
