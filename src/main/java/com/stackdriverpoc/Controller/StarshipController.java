package com.stackdriverpoc.Controller;

import com.stackdriverpoc.ErrorHandling.StarshipNotFoundException;
import com.stackdriverpoc.Aspect.LogExecutionTime;
import com.stackdriverpoc.Model.Starship;
import com.stackdriverpoc.Model.StarshipRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class StarshipController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarshipController.class);

    private final StarshipRepo repository;

    StarshipController(StarshipRepo repository) {
        this.repository = repository;
    }

    @LogExecutionTime
    @GetMapping("/ships")
    List<Starship> all() {
        List<Starship> temp = repository.findAll();
        List<String> collect = temp.stream().map(x -> x.getName()).collect(Collectors.toList());
        String str = collect.stream().map(x -> String.valueOf(x)).collect(Collectors.joining("---", "|", "|"));
        LOGGER.info("Getting all ships " + str);
        return temp;
    }

    @PostMapping("/ships")
    Starship newStarship(@RequestBody Starship newStarship) {
        return repository.save(newStarship);
    }

    // Single item

    @GetMapping("/ships/{id}")
    Starship one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new StarshipNotFoundException(id));
    }

    @PutMapping("/ships/{id}")
    Starship replaceStarship(@RequestBody Starship newStarship, @PathVariable Long id) {

        return repository.findById(id)
                .map(ship -> {
                    ship.setName(newStarship.getName());
                    ship.setPassengers(newStarship.getPassengers());
                    ship.setLength(newStarship.getLength());
                    ship.setHyperdriveRating(newStarship.getHyperdriveRating());
                    ship.setCrew(newStarship.getCrew());
                    ship.setModel(newStarship.getModel());
                    ship.setManufacturer(newStarship.getManufacturer());
                    return repository.save(ship);
                })
                .orElseGet(() -> {
                    newStarship.setId(id);
                    return repository.save(newStarship);
                });
    }

    @DeleteMapping("/ships/{id}")
    void deleteStarship(@PathVariable Long id) {
        repository.deleteById(id);
    }
}