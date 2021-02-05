package com.rfoe.msvc.foodie.restaurant;


import java.util.List;

import com.rfoe.msvc.foodie.common.enumeration.MenuTypeEnum;
import com.rfoe.msvc.foodie.restaurant.domain.entity.Menu;
import com.rfoe.msvc.foodie.restaurant.domain.entity.Restaurant;
import com.rfoe.msvc.foodie.restaurant.domain.repository.MenuRepository;
import com.rfoe.msvc.foodie.restaurant.domain.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * AppStartUpListener
 */
@Component
public class AppStartUpListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RestaurantRepository repo;

    @Autowired
    private MenuRepository menuRepo;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        // insert statement....
        Restaurant restaurant = new Restaurant();
        Menu menu = null;

        restaurant.setName("Mcdonald");
        restaurant.getAddress().setAddr01("Compassvale Link Blk 228");
        restaurant.getAddress().setAddr02("18-234");
        restaurant.getAddress().setCountry("Singapore");
        repo.save(restaurant); // generete transient PK 

        menu = restaurant.addMenu();
        menu.setName("Big Mac");
        menu.setPrice(3.2d);
        menu.setType(MenuTypeEnum.ALACARTE);
        // menuRepo.save(menu);

        menu = restaurant.addMenu();
        menu.setName("Chicken Burger");
        menu.setPrice(2d);
        menu.setType(MenuTypeEnum.ALACARTE);
        // menuRepo.save(menu);

        menu = restaurant.addMenu();
        menu.setName("Beef Burger");
        menu.setPrice(4d);
        menu.setType(MenuTypeEnum.ALACARTE);
        // menuRepo.save(menu);

        repo.save(restaurant);


        // Menu menu = new Menu();
        // menu.setName("Beef Burger");
        // menu.setPrice(4d);
        // menu.setType(MenuTypeEnum.ALACARTE);
        // menuRepo.save(menu);

        List<Menu> menus = menuRepo.findAll();
        for(Menu item : menus){
            System.err.println(item.getId());
        }

        // repo.findById(restaurant.getId())

        // System.err.println(menu.getId());




    }
    


    
}