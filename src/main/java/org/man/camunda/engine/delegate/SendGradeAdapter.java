package org.man.camunda.engine.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.man.camunda.config.ProcessConstants;
import org.man.camunda.model.Student;
import org.man.camunda.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties
@Slf4j
public class SendGradeAdapter implements JavaDelegate {

    @Autowired
    StreamService streamService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String studentId = (String) delegateExecution.getVariable(ProcessConstants.VAR_NAME_STUDENT_ID);
        String grade = (String) delegateExecution.getVariable(ProcessConstants.VAR_NAME_GRADE);
        int gradeNumber = (int) delegateExecution.getVariable(ProcessConstants.VAR_NAME_GRADE_NUMBER);

        Student studentInfo = new Student().setStudentId(studentId).setGrade(grade).setGradeNumber(gradeNumber);

        streamService.send(studentInfo);

    }
}
