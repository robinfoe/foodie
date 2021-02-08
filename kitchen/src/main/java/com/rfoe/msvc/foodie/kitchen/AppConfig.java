package com.rfoe.msvc.foodie.kitchen;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.rfoe.msvc.foodie.kitchen.handler.OrderEventListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {

    

    @Autowired
    private OrderEventListener listener;

    @Bean
    public DirectProcessor<String> getFlux(){
        return DirectProcessor.create();
    }

    @Bean
    public FluxSink<String> kitchenEventChannel(DirectProcessor<String> processor){
        return processor.sink();
    }

    @Bean
    public Supplier<Flux<String>> kitchenEventPublisher(DirectProcessor<String> processor){
        return () -> processor;
    }

    @Bean
    public Consumer<String> orderEventConsumer(){
        return listener::orderCreated;
    }


}