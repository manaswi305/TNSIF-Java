package userdemo;



import userdemo.User;
import userdemo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    private boolean isLoggedIn = false;

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(String name, String password) {
        User existing = userRepository.findByNameAndPassword(name, password);
        if (existing != null) {
            isLoggedIn = true;
            return existing;
        }
        return null;
    }


    @Override
    public boolean logOut() {
        isLoggedIn = false;
        return true;
    }
}
