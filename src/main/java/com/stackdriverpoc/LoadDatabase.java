package com.stackdriverpoc;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(BookRepo repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Book("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Book("Frodo Baggins", "thief")));
        };
    }
}
