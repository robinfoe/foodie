package com.rfoe.msvc.foodie.consumer;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

@Configuration
@EnableSwagger2
public class AppConfig {

    // @Bean
	// public Docket postsApi() {
	// 	return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
	// 			.apiInfo(apiInfo()).select().paths(postPaths()).build();
	// }

	// private Predicate<String> postPaths() {
	// 	return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
	// }



    

//   @Bean
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