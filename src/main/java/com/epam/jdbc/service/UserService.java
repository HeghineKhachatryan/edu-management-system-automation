package com.epam.jdbc.service;

import com.epam.jdbc.config.DBConnectionProvider;

import java.sql.Connection;

public interface UserService<T> {

    Connection connection = DBConnectionProvider.getInstance().getConnection();

    T findUserByEmail(String email);
}
