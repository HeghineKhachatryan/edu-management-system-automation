package com.epam.jdbc.service.serviceimpl;

import com.epam.jdbc.config.DBConnectionProvider;
import com.epam.jdbc.service.YearsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;

public class AcademicYearsServiceImpl implements YearsService {
    private final Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final Logger logger = LoggerFactory.getLogger(AcademicYearsServiceImpl.class);
    @Override
<<<<<<< HEAD
    public int findIDByStartAndEndDays(LocalDate startDate, LocalDate endDate) {
=======
    public int getIDByStartAndEndDays(LocalDate startDate, LocalDate endDate) {
>>>>>>> 6404f16d240aaf9fab9529664ffe7e1fb48bb912
        int id = -1;
        logger.info("Check if academic year is added to the DB by filling start and end dates.");
        String query = "SELECT id FROM public.academic_year WHERE start_date=? and end_date=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, Date.valueOf(startDate));
            preparedStatement.setDate(2, Date.valueOf(endDate));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
<<<<<<< HEAD
            logger.error("Can not execute query. Something went wrong.");
            throw new RuntimeException("Can not execute query. Something went wrong.");
=======
            logger.error("Can not execute query");
            throw new RuntimeException(e);
>>>>>>> 6404f16d240aaf9fab9529664ffe7e1fb48bb912
        }
        return id;
    }
}
