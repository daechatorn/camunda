package org.man.camunda.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProcessConstants {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static final String PROCESS_KEY_GRADE_SENDER = "gradeSender";
    public static final String PROCESS_KEY_GRADE_RECEIVER = "gradeReceiver";

    public static final String VAR_NAME_STUDENT = "student";
    public static final String VAR_NAME_STUDENT_ID = "studentId";
    public static final String VAR_NAME_GRADE = "grade";
    public static final String VAR_NAME_GRADE_NUMBER = "gradeNumber";

}
