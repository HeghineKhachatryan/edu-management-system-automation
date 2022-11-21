package com.epam.jdbc.service;

import com.epam.jdbc.model.AcademicCourse;

public interface AcademicCourseService {

    AcademicCourse findByName(String academicCourseName);

    int findAcademicCourseIdByLinkedClassId(int academicClassId);
    int findTeachersCountByLinkedCourseId(int subjectID);
}
