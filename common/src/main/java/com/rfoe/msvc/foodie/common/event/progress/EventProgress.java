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

    

    private Optional<Event> getNextEvent(EventEnum eventing, OrderEnum ordering){
        return getEvent(eventing, ordering, true);
    }

    private Optional<Event> getCurrentEvent(EventEnum eventing, OrderEnum ordering){
        return getEvent(eventing, ordering, false);
    }

    private Optional<Event> getEvent(EventEnum eventing, OrderEnum ordering, boolean isNext){

        Optional<Event> eventOpt = Optional.empty();
        int i = this.getEventIndex(eventing, ordering);
        if(i >= 0 ){

            if(isNext){
                i++;
            }
            
            if(i < events.size() ){
                eventOpt = Optional.of(events.get( i ));
            }
        }

        return eventOpt;
    }


    private int getEventIndex(EventEnum eventing, OrderEnum ordering){
        
        int index = -1;
        for(int i = 0; i < events.size(); i++){
            Event item = events.get(i);
            if(eventing != null){
                if(item.getEvent().equals(eventing)){
                    index = i;
                    break;
                }
            }else if(ordering != null){
                if(item.getOrder().equals(ordering)){
                    index = i;
                    break;
                }
            }
        }

        return index;
    }


    // HELPER FUNCTIONS...

    public Optional<Event> getNextEventByOrderEnum(OrderEnum item){
        return this.getNextEvent(null, item);
    }

    public Optional<Event> getNextEventByEventEnum(EventEnum item){
        return this.getNextEvent(item, null);
    }

    public Optional<Event> getCurrentEventByOrderEnum(OrderEnum item){
        return this.getCurrentEvent(null, item);
    }

    public Optional<Event> getCurrentEventByEventEnum(EventEnum item){
        return this.getCurrentEvent(item, null);
    }



    // STATIC.... 
    public static EventProgress getInstance(){

        if(EventProgress.instance == null){
            EventProgress.instance = new EventProgress();
        }
        return EventProgress.instance;
    }



    
}
