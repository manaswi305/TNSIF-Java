package userdemo;
import userdemo.User;


public interface IUserService {
    User addNewUser(User user);
    User updateUser(User user);
    User login(String name, String password);
    boolean logOut();
}
