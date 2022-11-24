package com.example.rappitspring.config;


import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.JsonbMessageConverter;


@Configuration
public class messageconfig {

    public static final  String Queue = "javatechie_queue";
    public static final  String Queue1 = "Ahmed";

    public static final  String Queue2 = "Mohamed";

    public static final  String Exchange = "javatechie_exchange";

    public static final  String RoutingKey = "javatechie_routingKey";
    public static final  String RoutingKey1 = "Ahmed_routing";

    public static final  String RoutingKey2 = "Mohamed_routing";



    @Bean
    public Queue queue(){
        return new Queue(Queue);
    }
    @Bean
    public Queue queue1(){
        return new Queue(Queue1);
    }
    @Bean
    public Queue queue2(){
        return new Queue(Queue2);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(Exchange);

    }



    @Bean
    public Binding binding (Queue queue , TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(RoutingKey);
    }

    @Bean
    public Binding binding1 (Queue queue1 , TopicExchange exchange1){
        return BindingBuilder.bind(queue1).to(exchange1).with(RoutingKey1);

    }

    @Bean
    public Binding binding2 (Queue queue2 , TopicExchange exchange2){
        return BindingBuilder.bind(queue2).to(exchange2).with(RoutingKey2);
    }


    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }


    public AmqpTemplate template (ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate((org.springframework.amqp.rabbit.connection.ConnectionFactory) connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate ;


    }


}
