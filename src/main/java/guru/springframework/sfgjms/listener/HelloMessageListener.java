package guru.springframework.sfgjms.listener;

import guru.springframework.sfgjms.config.JmsConfig;
import guru.springframework.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

/**
 * Created by jt on 2019-07-17.
 */
@RequiredArgsConstructor
@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        //System.out.println("I Got a Message!!!!!");

       // System.out.println(helloWorldMessage);


        // uncomment and view to see retry count in debugger
       // throw new RuntimeException("foo");

    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message,
                        org.springframework.messaging.Message springImplMessage) throws JMSException {

        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World!!")
                .build();

        //message is the jms interface implementation
        //springImplMessage is the spring implementation of the jms message, it does abstraction to it
        //so if we want to switch from one jmsmessage provider(like activemq) to another its easier if using teh spring jms abstraction
        jmsTemplate.convertAndSend((Destination) springImplMessage.getHeaders().get("jms_replyTo"), payloadMsg);

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);

    }

}
