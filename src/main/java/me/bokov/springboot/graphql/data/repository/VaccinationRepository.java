package me.bokov.springboot.graphql.data.repository;

import me.bokov.springboot.graphql.data.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository <Vaccination, Long> {

}
