package com.busyzero.demo.stream.stream;

import com.busyzero.demo.stream.model.OrganizationChangeModel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CustomChannels.class)
public class MsgSink {

    @StreamListener("inbound")
    public void process(OrganizationChangeModel obj) {
        System.out.println(obj);
    }
}
