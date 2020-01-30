package me.bokov.springboot.graphql.data.repository;

import me.bokov.springboot.graphql.data.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository <Animal, Long> {

}