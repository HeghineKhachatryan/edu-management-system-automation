package com.epam.jdbc.service.serviceimpl;

import com.epam.jdbc.config.DBConnectionProvider;
import com.epam.jdbc.model.AcademicCourse;
import com.epam.jdbc.service.AcademicCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcademicCourseServiceImpl implements AcademicCourseService {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public AcademicCourse findByName(String academicCourseName) {
        AcademicCourse academicCourse = new AcademicCourse();
        String query = "SELECT * " +
                "FROM public.\"academic_course\"" +
                "WHERE name=?;";
        logger.info("Find academic course by name");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, academicCourseName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                academicCourse.setId(resultSet.getInt("id"));
                academicCourse.setName(resultSet.getString("name"));
                academicCourse.setSubjectId(resultSet.getInt("subject_id"));
            }
        } catch (SQLException e) {
            logger.error("Can not execute query");
            throw new RuntimeException("Can not execute query, something went wrong");
        }
        return academicCourse;
    }

    @Override
    public int findAcademicCourseIdByLinkedClassId(int academicClassId) {
        logger.info("Find ID of the given academic course.");
        int id = -1;
        String query = "SELECT academic_course_id " +
                "FROM public.academic_class_academic_course_mapping " +
                "WHERE academic_class_id=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, academicClassId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("academic_course_id");
            }
        } catch (SQLException e) {
            logger.error("Can not execute query.");
            throw new RuntimeException("Can not execute query. Something went wrong.");
        }
        return id;
    }
}
