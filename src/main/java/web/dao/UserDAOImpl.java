package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user",User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(User id) {
        entityManager.remove(id);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(getById(user.getId()));
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);

    }

    @Override
    public void save(User user) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(id);

    }
}