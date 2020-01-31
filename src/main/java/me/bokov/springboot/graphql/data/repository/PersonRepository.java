package me.bokov.springboot.graphql.data.repository;

import me.bokov.springboot.graphql.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
