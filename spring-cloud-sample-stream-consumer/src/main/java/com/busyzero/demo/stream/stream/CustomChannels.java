package com.busyzero.demo.stream.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CustomChannels {
    @Input("inbound")
    SubscribableChannel inOrgs();

//    @Output("outbound")
//    MessageChannel outOrgs();
}
