package com.epam.jdbc.service.serviceimpl;

import com.epam.jdbc.config.DBConnectionProvider;
import com.epam.jdbc.model.User;
import com.epam.jdbc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Override
    public User findUserByEmail(String email) {
        User user = new User();
        String query = "SELECT * " +
                "FROM public.\"user\"" +
                "WHERE email=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
                user.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

}
