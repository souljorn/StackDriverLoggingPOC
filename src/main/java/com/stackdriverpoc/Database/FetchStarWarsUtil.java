package com.stackdriverpoc.Database;

import com.stackdriverpoc.Model.Starship;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class FetchStarWarsUtil {
   public RestTemplate restTemplate;
   public Starship starship;

    FetchStarWarsUtil() {
        restTemplate = new RestTemplate();
        starship = restTemplate.getForObject("https://swapi.co/api/starships", Starship.class);
    }
}

