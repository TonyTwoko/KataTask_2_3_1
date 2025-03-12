package springCourse.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import springCourse.model.User;

import java.sql.*;

import java.util.List;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users"
                , new BeanPropertyRowMapper<>(User.class));
    }


    public User show(int id) {
        return jdbcTemplate.query("SELECT * FROM Users WHERE id = ?"
                        , new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findFirst().orElse(null);
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO Users VALUES (1,?,?,?,?)"
                , user.getName(), user.getSurname(), user.getAge(), user.getEmail());
    }

    public void update(int id, User userUpdate) {
        jdbcTemplate.update("UPDATE Users SET name = ?, surname = ?, age = ?, email = ? WHERE id = ?"
                , userUpdate.getName(), userUpdate.getSurname()
                , userUpdate.getAge(), userUpdate.getEmail(), id);
    }

    public void delete(int id) {
      jdbcTemplate.update("DELETE FROM Users WHERE id = ?", id);
    }
}
