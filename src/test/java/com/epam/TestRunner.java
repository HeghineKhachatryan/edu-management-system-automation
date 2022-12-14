package com.epam;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features\\3admin\\3add_students_for_academic_classes.feature",
        glue = "com\\epam\\steps",
        publish = true)
public class TestRunner {
}
