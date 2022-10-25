package com.epam.jdbc.service.serviceimpl;

import com.epam.jdbc.config.DBConnectionProvider;
import com.epam.jdbc.model.Teacher;
import com.epam.jdbc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherServiceImpl implements UserService<Teacher> {

    private final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Override
    public Teacher findUserByEmail(String email) {
        Teacher teacher = new Teacher();
        String query = "SELECT public.teacher.id, password, name, surname, email " +
                "FROM public.user " +
                "INNER JOIN public.teacher " +
                "ON public.user.id=public.teacher.user_id " +
                "WHERE public.user.email=?;";
        logger.info("Find teacher by email");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSurname(resultSet.getString("surname"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            logger.error("Can not execute query");
            throw new RuntimeException("Can not execute query, something went wrong");
        }
        return teacher;
    }
}
