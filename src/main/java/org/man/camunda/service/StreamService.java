package org.man.camunda.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.Variables;
import org.man.camunda.config.ProcessConstants;
import org.man.camunda.model.Student;
import org.man.camunda.service.stream.StreamChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;


import static org.man.camunda.config.ProcessConstants.mapper;

@Component
@Slf4j
@EnableBinding(StreamChannel.class)
public class StreamService {

    @Autowired
    StreamChannel streamChannel;

    @Autowired
    private ProcessEngine camunda;


    @StreamListener(StreamChannel.MYOUTPUT)
    public void send(Student student) {
        log.info("Send student with student:{}", student);
        streamChannel.myoutput().send(MessageBuilder.withPayload(student).build());
    }

    @StreamListener(StreamChannel.MYINPUT)
    public void received(Student student) throws JsonProcessingException {
        log.info("Receive student with student:{}", student);
        log.info("Start print grade receiver process from student:{}", student);
        camunda.getRuntimeService().startProcessInstanceByKey(//
                ProcessConstants.PROCESS_KEY_GRADE_RECEIVER, //
                Variables //
                        .putValue(ProcessConstants.VAR_NAME_STUDENT, mapper.writeValueAsString(student)));
    }

}
