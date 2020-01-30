package me.bokov.springboot.graphql.data.repository;

import me.bokov.springboot.graphql.data.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository <Species, Long> {

}
