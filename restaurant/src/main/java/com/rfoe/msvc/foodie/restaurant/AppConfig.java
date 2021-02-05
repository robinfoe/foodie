package com.rfoe.msvc.foodie.restaurant;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

@Configuration
@EnableSwagger2
public class AppConfig {

  // @Bean
  // public RouterFunction<ServerResponse> route(RestaurantWebHandler handler) {

  //   return RouterFunctions.route()
  //                 .GET("/", RequestPredicates.accept(MediaType.TEXT_PLAIN), handler::getAllRestaurant)
  //                 .GET("/{id}", handler::getRestaurantById )
  //                 // .POST("/create", RequestPredicates.contentType(MediaType.APPLICATION_JSON), handler::create)
  //                 .build();

  //   // return RouterFunctions
  //   //             .route(RequestPredicates.GET("/hello")
  //   //                 .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello)
  // }




  // @Bean
  //   public DirectProcessor<String> getFlux(){
  //       return DirectProcessor.create();
  //   }

  //   @Bean
  //   public FluxSink<String> consumerEventChannel(DirectProcessor<String> processor){
  //       return processor.sink();
  //   }

  //   @Bean
  //   public Supplier<Flux<String>> consumerEventPublisher(DirectProcessor<String> processor){
  //       return () -> processor;
  //   }
   
    // @Bean
    // public Consumer<PaymentEvent> paymentEventConsumer(){
    //     return consumerService::consumerPayment;
    // }




    // @Autowired
    // DataSourceProperties dataSourceProperties;

    // @Bean
    // DataSource dataSource() {
    //     DataSource dataSource = DataSourceBuilder
    //             .create(this.dataSourceProperties.getClassLoader())
    //             .url(this.dataSourceProperties.getUrl())
    //             .username(this.dataSourceProperties.getUsername())
    //             .password(this.dataSourceProperties.getPassword())
    //             .build();
    //     return new DataSourceSpy(dataSource);
    // }
}