package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.models.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public void editUser(User id) {
        userDAO.edit(id);

    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

}
