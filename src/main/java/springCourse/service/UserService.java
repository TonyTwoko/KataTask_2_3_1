package springCourse.service;

import springCourse.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User show(int id);
    void save(User user);
    void update(int id, User userUpdate);
    void delete(int id);
    }

