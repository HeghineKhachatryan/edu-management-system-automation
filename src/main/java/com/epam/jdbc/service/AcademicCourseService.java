package com.epam.jdbc.service;

import com.epam.jdbc.model.AcademicCourse;

public interface AcademicCourseService {

    AcademicCourse findByName(String academicCourseName);
}
