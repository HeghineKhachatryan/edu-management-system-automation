package com.epam.jdbc.service;

import java.time.LocalDate;

public interface YearsService {
    int getIDByStartAndEndDays(LocalDate startDate, LocalDate endDate);
}
