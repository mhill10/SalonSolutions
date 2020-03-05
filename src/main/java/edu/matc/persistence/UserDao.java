package edu.matc.persistence;

import com.mysql.cj.xdevapi.SessionFactory;
import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {

    // Add logging to this class
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    /**
 * Gets all Users
 *
 * @return all salon users
 */
public List<User> getAllUsers() {

    Session session  = sessionFactory.openSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<User> query = builder.createQuery(User.class);
    Root<User> root =  query.from(User.class);
    List<User> users = session.createQuery(query).getResultList();
    session.close();
    return users;

}

}
