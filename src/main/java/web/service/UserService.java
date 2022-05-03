package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void save(User user);
    User getById(Long id);
    void editUser(User id);
    void deleteUser(long id);
}
