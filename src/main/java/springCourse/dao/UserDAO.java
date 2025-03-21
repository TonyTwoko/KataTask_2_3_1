package springCourse.dao;

import springCourse.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    User show(int id);
    void save(User user);
    void update(int id, User userUpdate);
    void delete(int id);
}
