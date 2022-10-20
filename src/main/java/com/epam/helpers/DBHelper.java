package com.epam.helpers;

import com.epam.jdbc.service.serviceimpl.AdminServiceImpl;
import com.epam.jdbc.service.serviceimpl.StudentServiceImpl;
import com.epam.jdbc.service.serviceimpl.TeacherServiceImpl;
import com.epam.jdbc.service.serviceimpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBHelper {

    private final UserServiceImpl userService = new UserServiceImpl();
    private final AdminServiceImpl adminService = new AdminServiceImpl();
    private final TeacherServiceImpl teacherService = new TeacherServiceImpl();
    private final StudentServiceImpl studentService = new StudentServiceImpl();
    private final Logger logger = LoggerFactory.getLogger(DBHelper.class);


    public boolean isUserAddedInTheDB() {
        return userService.findUserByEmail(SharedTestData.getLastGeneratedEmail()).getEmail() == null;
    }
    public boolean isAdminPasswordHashed() {
        logger.info("Check password is encrypted");
        return !adminService.findUserByEmail(SharedTestData.getLastGeneratedEmail()).getPassword()
                .equals(SharedTestData.getLastGeneratedPassword());
    }

    public boolean isTeacherPasswordHashed() {
        logger.info("Check password is encrypted");
        return !teacherService.findUserByEmail(
                        SharedTestData.getLastGeneratedEmail()).getPassword()
                .equals(SharedTestData.getLastGeneratedPassword());
    }

    public boolean isStudentPasswordHashed() {
        logger.info("Check password is encrypted");
        return !studentService.findUserByEmail(
                        SharedTestData.getLastGeneratedEmail()).getPassword()
                .equals(SharedTestData.getLastGeneratedPassword());
    }
}
