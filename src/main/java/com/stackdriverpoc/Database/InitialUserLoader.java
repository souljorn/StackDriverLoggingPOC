package com.stackdriverpoc.Database;

import com.stackdriverpoc.Model.User;
import com.stackdriverpoc.Model.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitialUserLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;
    private static Logger LOG = LoggerFactory.getLogger(FetchStarWarsUtil.class);


    @Autowired
    private UserRepo userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        User user = new User();
        user.setUserName("Tim");
        user.setPassword("pass");
        user.setEmail("test@test.com");
        userRepository.save(user);
    }

    @Bean
    public void logUser(){
        LOG.info("User Created:");
        try {
        } catch (Exception e) {
        }
    }
}
