package edu.matc.persistence;

import com.mysql.cj.xdevapi.SessionFactory;
import edu.matc.entity.GuestUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GuestUserDao {

    // Add logging to this class
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    /**
 * Gets all GuestUsers
 *
 * @return all guest users
 */
public List<GuestUser> getAllGuestUsers() {

    Session session  = sessionFactory.openSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<GuestUser> query = builder.createQuery(GuestUser.class);
    Root<GuestUser> root =  query.from(GuestUser.class);
    List<GuestUser> users = session.createQuery(query).getResultList();
    session.close();
    return users;

}

}
