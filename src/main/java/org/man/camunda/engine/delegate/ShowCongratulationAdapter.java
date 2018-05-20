package org.man.camunda.engine.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.man.camunda.config.ProcessConstants;
import org.man.camunda.model.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static org.man.camunda.config.ProcessConstants.mapper;


@Component
@ConfigurationProperties
@Slf4j
public class ShowCongratulationAdapter implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Start ShowCongratulationAdapter");
        String studentInfo = (String) delegateExecution.getVariable(ProcessConstants.VAR_NAME_STUDENT);
        Student student = mapper.readValue(studentInfo, Student.class);
        log.info("Congratulation!!! {}", student.toString());
    }

}
