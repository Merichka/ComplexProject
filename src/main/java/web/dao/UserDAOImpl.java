package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import java.util.List;
import static javax.swing.UIManager.get;

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
        entityManager.merge(get(user.getId()));
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(id);
    }
}
