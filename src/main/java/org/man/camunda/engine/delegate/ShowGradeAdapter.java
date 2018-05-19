package org.man.camunda.engine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.man.camunda.constants.ProcessConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties
public class ShowGradeAdapter implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String studentId = (String) delegateExecution.getVariable(ProcessConstants.VAR_NAME_studentId);
        String grade = (String) delegateExecution.getVariable(ProcessConstants.VAR_NAME_grade);
        int gradeNumber = (int) delegateExecution.getVariable(ProcessConstants.VAR_NAME_gradeNumber);

        System.out.println("ShowGradeAdapter: studentId:{"+studentId+"}, grade:{"+grade+"}, gradeNumber:{"+gradeNumber+"}");
    }
}
