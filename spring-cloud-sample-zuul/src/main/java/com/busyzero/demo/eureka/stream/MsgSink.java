//package com.busyzero.demo.stream.stream;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//
//@EnableBinding(TestSink.class)
//public class MsgSink {
//
//    @StreamListener(TestSink.INPUT)
//    public void process(Object obj) {
//        System.out.println(obj);
////        System.out.println(message.getPayload());
////        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
////        if (acknowledgment != null) {
////            System.out.println("Acknowledgment provided");
////            acknowledgment.acknowledge();
////        }
//    }
//}
