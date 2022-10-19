package com.epam.jdbc.service;

import com.epam.jdbc.config.DBConnectionProvider;
import com.epam.jdbc.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService implements UserService<Student> {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public Student findUserByEmail(String email) {
        Student student = new Student();
        String query = "SELECT public.student.id, name, surname, email, password, address, gender, " +
                "blood_group, date, academic_class_id, parent_id " +
                "FROM public.user INNER JOIN public.student " +
                "ON public.user.id=public.student.user_id WHERE public.user.email=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setEmail(resultSet.getString("email"));
                student.setPassword(resultSet.getString("password"));
                student.setGender(resultSet.getString("gender"));
                student.setAddress(resultSet.getString("address"));
                student.setBloodGroup(resultSet.getString("blood_group"));
                student.setLinkedClass(resultSet.getString("academic_class_id"));
                student.setLinkedParent(resultSet.getString("parent_id"));
                student.setBirthDay(resultSet.getDate("date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
