package org.man.camunda.engine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.man.camunda.constants.ProcessConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties
public class CalculateGradeAdapter implements JavaDelegate {

    public int i = 0;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println(i++);
        String studentId = (String) delegateExecution.getVariable(ProcessConstants.VAR_NAME_studentId);
        String grade = (String) delegateExecution.getVariable(ProcessConstants.VAR_NAME_grade);

        System.out.println("CalculateGradeAdapter: studentId:{"+studentId+"}, grade:{"+grade+"}");
        int gradeNumber = 0;

        switch (grade){
            case "A":
                gradeNumber = 4;
                break;
            case "B":
                gradeNumber = 3;
                break;
            default:
                gradeNumber = 0;
                break;
        }

        delegateExecution.setVariable(ProcessConstants.VAR_NAME_gradeNumber, gradeNumber);
    }
}
