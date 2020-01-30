package me.bokov.springboot.graphql.data.repository;

import me.bokov.springboot.graphql.data.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository <Food, Long> {

}
