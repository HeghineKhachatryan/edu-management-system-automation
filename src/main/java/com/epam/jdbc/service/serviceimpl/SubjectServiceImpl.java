package com.epam.jdbc.service.serviceimpl;

import com.epam.jdbc.config.DBConnectionProvider;
import com.epam.jdbc.model.Subject;
import com.epam.jdbc.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectServiceImpl implements SubjectService {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Override
    public Subject findByName(String name) {
        Subject subject = new Subject();
        String query = "select * from subject where name=?";
        logger.info("Find subject by name");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            logger.error("Can not execute query");
            throw new RuntimeException("Can not execute query, something went wrong");
        }
        return subject;
    }
}
