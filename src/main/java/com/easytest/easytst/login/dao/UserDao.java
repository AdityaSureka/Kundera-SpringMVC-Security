package com.easytest.easytst.login.dao;

import com.easytest.easytst.login.model.User;

public interface UserDao {

	User findByUserName(String username);

}