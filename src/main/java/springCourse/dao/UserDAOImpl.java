package springCourse.dao;

import org.springframework.stereotype.Component;
import springCourse.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User userUpdate) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(userUpdate.getName());
            user.setSurname(userUpdate.getSurname());
            user.setAge(userUpdate.getAge());
            user.setEmail(userUpdate.getEmail());
            entityManager.merge(user);
        }
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
