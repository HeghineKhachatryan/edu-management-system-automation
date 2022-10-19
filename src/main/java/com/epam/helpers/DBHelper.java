package com.epam.helpers;

import com.epam.jdbc.service.AdminService;
import com.epam.jdbc.service.StudentService;
import com.epam.jdbc.service.TeacherService;
import com.epam.jdbc.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBHelper {

    private final UserServiceImpl userService = new UserServiceImpl();
    private final AdminService adminService = new AdminService();
    private final TeacherService teacherService = new TeacherService();
    private final StudentService studentService = new StudentService();
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
