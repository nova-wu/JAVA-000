package com.github.novawu.springsample.jdbc.dao;

import com.github.novawu.springsample.jdbc.entity.User;

public interface UserDao {

    void save(User user);

    void update(User user);

    User selectOneById(Long id);

    void deleteById(Long id);
}
