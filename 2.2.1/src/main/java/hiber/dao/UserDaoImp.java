package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
   }

   @Override
   public User getUserByCar(String model, long series) {
    return sessionFactory.getCurrentSession()
             .createQuery("from User as user inner join user.car where user.car.model = :model and  user.car.series = :series", User.class)
            .setParameter("model", model)
            .setParameter("series", series)
            .uniqueResult();
   }
}
