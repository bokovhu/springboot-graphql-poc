package me.bokov.springboot.graphql.data.repository;

import me.bokov.springboot.graphql.data.entity.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodRepositoryTest {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void foodCanBeCreated () {

        Food food = new Food ();
        food.setContainsMeat (true);
        food.setContainsPlants (false);
        food.setName ("Raw Beef");
        food.setPriceInEur (12.0);
        food = foodRepository.save (food);

        assertNotNull (food.getId ());

    }

    @Test
    public void foodsCanBeQueried () {

        Food mushroom = new Food ();
        mushroom.setContainsMeat (false);
        mushroom.setContainsPlants (true);
        mushroom.setName ("Raw Mushroom");
        mushroom.setPriceInEur (1.8);
        mushroom = foodRepository.saveAndFlush (mushroom);

        List <Food> list = foodRepository.findAll ();
        assertFalse (list.isEmpty ());

    }

}