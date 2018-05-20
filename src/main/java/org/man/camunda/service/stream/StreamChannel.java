package org.man.camunda.service.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StreamChannel {

    String MYOUTPUT = "myoutput";
    @Output("myoutput")
    MessageChannel myoutput();

    String MYINPUT = "myinput";
    @Input("myinput")
    MessageChannel myinput();

}
