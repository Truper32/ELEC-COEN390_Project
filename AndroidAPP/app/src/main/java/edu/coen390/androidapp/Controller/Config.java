package edu.coen390.androidapp.Controller;

import java.util.Hashtable;

import edu.coen390.androidapp.Model.Course;

/**
 * Configuration class that holds the db table and column names.
 */
public class Config {
    public static final String DATABASE_NAME = "ExamApp-DB";

    public static final String INVIGILATOR_TABLE_NAME = "Invigilators";
    public static final String INVIGILATOR_ID = "InvigilatorID";
    public static final String INVIGILATOR_USERNAME = "InvigilatorUsername";
    public static final String INVIGILATOR_PASSWORD = "InvigilatorPassword";
    public static final String INVIGILATOR_FIRST_NAME = "InvigilatorFirstName";
    public static final String INVIGILATOR_LAST_NAME = "InvigilatorLastName";
    
    public static final String COURSE_TABLE_NAME = "Courses";
    public static final String COURSE_ID = "CourseID";
    public static final String COURSE_INVIGILATOR_ID = "InvigilatorID";
    public static final String COURSE_TITLE = "CourseTitle";
    public static final String COURSE_CODE = "CourseCode";
    public static final String COURSE_DESCRIPTION = "CourseDescription";
    public static final String COURSE_TOTAL_ENROLLED = "CourseTotalEnrolled";

    public static final String STUDENTS_TABLE_NAME = "Students";
    public static final String STUDENT_ID = "StudentID";
    public static final String STUDENT_COURSE_ID = "CourseID";
    public static final String STUDENT_FIRST_NAME = "StudentFirstName";
    public static final String STUDENT_LAST_NAME = "StudentLastName";
    public static final String STUDENT_USERNAME = "StudentUsername";
    public static final String STUDENT_PASSWORD = "StudentPassword";

    public static final Hashtable<String,String> EXAM_TABLE_NAME = new Hashtable<>();
    public static final String EXAM_ID = "ExamID";
    public static final String EXAM_COURSE_ID = "ExamCourseID";
    public static final String EXAM_STUDENT_ID = "ExamStudentID";
    public static final String EXAM_STUDENT_SEAT = "ExamStudentSeat";



}
