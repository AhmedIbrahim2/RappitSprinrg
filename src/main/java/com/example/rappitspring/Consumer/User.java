package com.example.rappitspring.Consumer;


import com.example.rappitspring.config.messageconfig;
import com.example.rappitspring.dto.Orderstatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

public class User {
  /*
    @RabbitListener(queues = messageconfig.Queue)
    public void consumemessagefromQueue (Orderstatus orderstatus){
        System.out.print("Message received from queue : /n"+ orderstatus);
    }
*/

    @RabbitListener(queues = messageconfig.Queue1)
    public void consumemessagefromQueue1 (Orderstatus orderstatus){
        System.out.print("Message received from queue 1 : "+ orderstatus);
    }

    @RabbitListener(queues = messageconfig.Queue2)
    public void consumemessagefromQueue2(Orderstatus orderstatus){
        System.out.print("Message received from queue 2 : " + orderstatus);
    }



}
