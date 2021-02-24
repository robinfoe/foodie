package com.rfoe.msvc.foodie.consumer;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * AppStartUpListener
 */
@Component
public class AppStartUpListener implements ApplicationListener<ApplicationReadyEvent> {

    // @Autowired
    // private ConsumerRepository repo;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        // Consumer consumer = new Consumer();

        // consumer.setName(new Name("Robin", "Foe"));
        // consumer.setEmail("test@email.com");
        
        // consumer.getHomeAddress().setAddr01("Jalan Kayu");
        // consumer.getHomeAddress().setPostcode("555555");
        // consumer.getHomeAddress().setCountry("Singapore");
        // consumer.getHomeAddress().setState("Singapore");

        // if(repo.findByEmailIgnoreCase(consumer.getEmail()).isEmpty()){
        //     repo.save(consumer);
        // }

    }
    
}