package com.stackdriverpoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepo repository) {
        return args -> {
            log.warn("Preloading " + repository.save(new Book("Bilbo Baggins", "burglar")));
            log.error("Preloading " + repository.save(new Book("Frodo Baggins", "thief")));
        };
    }
}
