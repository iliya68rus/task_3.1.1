package academy.kata.task.spring_boot.service;

import academy.kata.task.spring_boot.dao.UserDAO;
import academy.kata.task.spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
    public void editUser(long id, User user) {
        userDAO.editUser(id, user);
    }
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
}
