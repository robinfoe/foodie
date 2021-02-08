package com.rfoe.msvc.foodie.order.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.rfoe.msvc.foodie.common.base.BaseRepo;
import com.rfoe.msvc.foodie.common.base.BaseService;
import com.rfoe.msvc.foodie.common.enumeration.OrderEnum;
import com.rfoe.msvc.foodie.common.event.progress.Event;
import com.rfoe.msvc.foodie.common.event.progress.EventProgress;
import com.rfoe.msvc.foodie.common.scalar.dto.KitchenDTO;
import com.rfoe.msvc.foodie.common.scalar.dto.MenuDTO;
import com.rfoe.msvc.foodie.common.scalar.dto.OrderDTO;
import com.rfoe.msvc.foodie.common.scalar.dto.RestaurantDTO;
import com.rfoe.msvc.foodie.order.domain.entity.Order;
import com.rfoe.msvc.foodie.order.domain.entity.OrderDetail;
import com.rfoe.msvc.foodie.order.domain.repository.OrderRepository;
import com.rfoe.msvc.foodie.order.handler.OrderEventProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService extends BaseService<Order> {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private OrderEventProducer producer;

    @Override
    protected BaseRepo<Order> getRepo() {return this.repo;}



    @Value( "${app.restaurant.url}" )
    private String restaurantBaseUrl;

    @Transactional
    public List<OrderDTO> getAllDTO(){
        List<Order> orders = this.getAll();
        List<OrderDTO> dtos = new ArrayList<OrderDTO>();

        for(Order order : orders){
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setProgress(order.getProgress());
            dto.getRestaurant().setId(order.getRestaurantId());
            dto.getConsumer().setId(order.getConsumerId());
            dtos.add(dto);
        }
        
        return dtos;

    }

    // needed order DTO 
    @Transactional
    public OrderDTO submitOrder(OrderDTO orderDTO){

        try{
            String restaurantURL = new StringBuffer(restaurantBaseUrl)
                                        .append("/get/")
                                        .append(orderDTO.getRestaurant().getId().toString())
                                        .toString();

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<RestaurantDTO> restaurant =  restTemplate.getForEntity(restaurantURL, RestaurantDTO.class);
            if(restaurant.getBody().getId() != null){
                Order order = new Order();
                order.setDeliveryAddress(orderDTO.getConsumer().getHomeAddress());
                order.setConsumerId(orderDTO.getConsumer().getId());
                order.setRestaurantId(orderDTO.getRestaurant().getId());

                for(MenuDTO menu : orderDTO.getMenus()){
                    OrderDetail item = order.addDetail();
                    item.setMenuId(menu.getId());
                    item.setQuantity(menu.getQuantity());
                    item.setPrice(menu.getPrice());
                }

                repo.save(order);
                orderDTO.setId(order.getId());
                orderDTO.setMessage("Order Successfully Submitted");
                
                // Perform call to kafka streaming
                producer.raiseOrderCreatedEvent(orderDTO);
            }

            
        }catch(Exception e){
            e.printStackTrace();
            orderDTO.setErrorMessage(e.getMessage());
        }


        return orderDTO;
    }


    @Transactional
    public void updateKitchenProgress(KitchenDTO kitchenDTO){

        Optional<Event> event = EventProgress.getInstance().getCurrentEventByEventEnum(kitchenDTO.getEventType());
        if(event.isPresent()){
            this.updateOrder(kitchenDTO.getOrder(), event.get().getOrder());
        }else{
            log.info("updateKitchenProgress :: Event is invalid... ");
        }
        
    }

    @Transactional
    public OrderDTO cancelOrder(OrderDTO orderDTO){
        return updateOrder(orderDTO, OrderEnum.CANCELLED);
    }

    @Transactional
    public OrderDTO orderCompleted(OrderDTO orderDTO){
        return updateOrder(orderDTO, OrderEnum.COMPLETED);
    }

    @Transactional
    public OrderDTO updateOrder(OrderDTO orderDTO,OrderEnum progress){

        try{

            Optional<Order> orderOption = repo.findById(orderDTO.getId());

            if(!orderOption.isPresent()){
                throw new IllegalArgumentException("Order not found");
            }

            Order order = orderOption.get();

            //validation for progress
            if(OrderEnum.CANCELLED.equals(progress) && !order.isCreated()){
                throw new IllegalArgumentException("Order already in progress");
            }

            order.setProgress(progress);
            repo.save(order);

            switch (order.getProgress()) {
                case CANCELLED : break;
                case ACCEPTED : break;
                case PREPARING : break;
                case COMPLETED : break;
                default: ;
            }
            // sent order cancel event

            orderDTO.setMessage("Order successfully cancelled");
        }catch(Exception e){
            orderDTO.setErrorMessage(e.getMessage());
            throw e;
        }

        return orderDTO;
    }



    public String test() throws Exception{
        // if(true){
        //     throw new IllegalArgumentException("error happen");
        // }
        
        return "ok";
    }



    
}
