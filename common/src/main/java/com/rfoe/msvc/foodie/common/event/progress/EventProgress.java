package com.rfoe.msvc.foodie.common.event.progress;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.rfoe.msvc.foodie.common.enumeration.EventEnum;
import com.rfoe.msvc.foodie.common.enumeration.OrderEnum;

public class EventProgress {


    private static EventProgress instance;
    private List<Event> events = Arrays.asList( 
                            new Event(EventEnum.DOMAIN_ORDER_CREATED , OrderEnum.CREATED),
                            new Event(EventEnum.DOMAIN_KITCHEN_ACCEPT , OrderEnum.ACCEPTED),
                            new Event(EventEnum.DOMAIN_KITCHEN_PREPARING , OrderEnum.PREPARING),
                            new Event(EventEnum.DOMAIN_KITCHEN_COMPLETED , OrderEnum.COMPLETED)
                    );

    private EventProgress(){/**ENSURE SINGLETON*/}

    public Optional<Event> getNextEventByOrderEnum(OrderEnum item){
        return this.getNextEvent(null, item);
    }

    public Optional<Event> getNextEventByEventEnum(EventEnum item){
        return this.getNextEvent(item, null);
    }

    private Optional<Event> getNextEvent(EventEnum eventing, OrderEnum ordering){

        Optional<Event> eventOpt = Optional.empty();

        int i = 0;
        for(; i < events.size(); i++){
            Event item = events.get(i);
            if(eventing != null){
                if(item.getEvent().equals(eventing)){
                    break;
                }
            }else if(ordering != null){
                if(item.getOrder().equals(ordering)){
                    break;
                }
            }
        }

        i++;

        if(i < events.size() ){
            eventOpt = Optional.of(events.get( i ));
        }

        return eventOpt;
    }


    
    public static EventProgress getInstance(){

        if(EventProgress.instance == null){
            EventProgress.instance = new EventProgress();
        }
        return EventProgress.instance;
    }



    
}
