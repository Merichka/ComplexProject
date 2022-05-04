package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import java.util.List;

public interface UserDAO {
    List<User> allUsers();


    @Transactional
    void delete(User id);

    void edit(User user);

    void add(User user);

    void deleteUser(long id);
}
