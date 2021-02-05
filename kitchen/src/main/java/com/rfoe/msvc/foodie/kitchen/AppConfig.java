package com.rfoe.msvc.foodie.kitchen;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {

    

    // @Autowired
    // private KitchenEventListener consumerService;

    // @Bean
    // public DirectProcessor<String> getFlux(){
    //     return DirectProcessor.create();
    // }

    // @Bean
    // public FluxSink<String> orderEventChannel(DirectProcessor<String> processor){
    //     return processor.sink();
    // }

    // @Bean
    // public Supplier<Flux<String>> orderEventPublisher(DirectProcessor<String> processor){
    //     return () -> processor;
    // }

    // @Bean
    // public Consumer<String> kitchenEventConsumer(){
    //     return consumerService::consumeKitchenEvent;
    // }


}