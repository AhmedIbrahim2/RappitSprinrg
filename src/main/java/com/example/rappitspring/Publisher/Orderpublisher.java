package com.example.rappitspring.Publisher;


import com.example.rappitspring.config.messageconfig;
import com.example.rappitspring.dto.Order;
import com.example.rappitspring.dto.Orderstatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class Orderpublisher {

    @Autowired
    private RabbitTemplate template ;


    @PostMapping("/{resturantname}")
    public String bookorder(@RequestBody Order order ,@PathVariable String resturantname){
        order.setOrderId(UUID.randomUUID().toString());

        Orderstatus orderstatus = new Orderstatus(order , "Process","order placed successfully in :"+ resturantname);
        template.convertAndSend(messageconfig.Exchange , messageconfig.RoutingKey1 ,orderstatus);
        return "success !!!";
    }

    @PutMapping("/{resturantname}")
    public String bookorder2(@RequestBody Order order ,@PathVariable String resturantname){
        order.setOrderId(UUID.randomUUID().toString());

        Orderstatus orderstatus = new Orderstatus(order , "Process","order placed successfully in :"+ resturantname);
        template.convertAndSend(messageconfig.Exchange , messageconfig.RoutingKey2 ,orderstatus);
        return "success !!";
    }







}
