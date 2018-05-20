package org.man.camunda.controller;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.man.camunda.model.Student;
import org.man.camunda.config.ProcessConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/print")
@Slf4j
public class PrintController {

    @Autowired
    private ProcessEngine camunda;

    @RequestMapping(method= RequestMethod.POST)
    public String printGradePOST(@RequestBody Student student) {
        printGrade(student);
        return "Hello World!!!";
    }

    public ProcessInstance printGrade(Student student) {
        log.info("Start print grade sender process from student:{}", student);
        return camunda.getRuntimeService().startProcessInstanceByKey(//
                ProcessConstants.PROCESS_KEY_GRADE_SENDER, //
                Variables //
                        .putValue(ProcessConstants.VAR_NAME_STUDENT_ID, student.studentId) //
                        .putValue(ProcessConstants.VAR_NAME_GRADE, student.grade));
    }

}
