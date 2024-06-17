package com.sunbeam.dao;

import com.sunbeam.entity.User;

public interface UserDao {
String signUp(User user);
User getUserDetailsById(Long userId);
}
