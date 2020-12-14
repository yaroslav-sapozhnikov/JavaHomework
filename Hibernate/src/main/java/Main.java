import models.User;
import services.UserService;

public class Main {
    public static void main (String[] args){
        UserService userService = new UserService();
        User user = new User("yaroslav", 19);
        userService.saveUser(user);
        System.out.println("save user: " + user);

    }
}
