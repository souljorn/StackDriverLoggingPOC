//package com.stackdriverpoc.Database;
//
//import com.stackdriverpoc.Model.StarshipRepo;
//import com.stackdriverpoc.Model.Starship;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import java.util.*;
//
//@Configuration
//public class FetchStarWarsUtil {
//   public RestTemplate restTemplate;
//   public List<Starship> starships = new ArrayList<>();
//   private static Logger LOG = LoggerFactory.getLogger(FetchStarWarsUtil.class);
//
//    public FetchStarWarsUtil() {
//        LOG.info("Fetching Star Wars data...");
//        restTemplate = new RestTemplate();
//        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity("https://swapi.co/api/starships", LinkedHashMap.class);
//        LinkedHashMap map = response.getBody();
//        Object results =  map.get("results");
//        List<?> list;
//        if(results instanceof Collection){
//            list = new ArrayList<>((Collection<?>) results);
//            starships = parseToStarShips(list);
//        }
//    }
//
//    public List<Starship> parseToStarShips(List items){
//        List<Starship> temp = new ArrayList<>();
//
//        items.getClass();
//        for (Object item : items) {
//            Starship starship = new Starship();
//            if(item instanceof LinkedHashMap){
//                String name = ((LinkedHashMap) item).get("name").toString();
//                String model = ((LinkedHashMap) item).get("model").toString();
//                String manufacturer = ((LinkedHashMap) item).get("manufacturer").toString();
//                String length = ((LinkedHashMap) item).get("length").toString();
//                String crew = ((LinkedHashMap) item).get("crew").toString();
//                String passengers = ((LinkedHashMap) item).get("passengers").toString();
//                String hyperdriveRating = ((LinkedHashMap) item).get("hyperdrive_rating").toString();
//                starship.setName(name);
//                starship.setModel(model);
//                starship.setManufacturer(manufacturer);
//                starship.setCrew(crew);
//                starship.setHyperdriveRating(hyperdriveRating);
//                starship.setLength(length);
//                starship.setPassengers(passengers);
//                temp.add(starship);
//            }
//        }
//        return temp;
//    }
//
//    @Bean
//    CommandLineRunner initDatabase(StarshipRepo repository) {
//        return args -> {
//            for (Starship ship : starships
//            ) {
//                LOG.warn("Preloading =====> " + repository.save(ship));
//            }
//        };
//    }
//}
//
