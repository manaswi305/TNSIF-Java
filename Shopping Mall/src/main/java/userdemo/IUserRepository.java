package userdemo;

import userdemo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByNameAndPassword(String name, String password);
}
