package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void save(User user);
    public List<User> findAll();
    public User findById(int id);
    public void update(User user);
    public void delete(int id);
}
