package me.bokov.springboot.graphql.gql.mapper;

import me.bokov.springboot.graphql.data.entity.Species;
import me.bokov.springboot.graphql.gql.dto.SpeciesDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Component
@Transactional
public class SpeciesToDTO implements Function<Species, SpeciesDTO> {

    @Override
    public SpeciesDTO apply (Species species) {

        SpeciesDTO dto = new SpeciesDTO ();

        dto.setId (species.getId ().toString ());
        dto.setName (species.getName ());
        dto.setParentSpeciesId (
                species.getParentSpecies () == null
                        ? null
                        : species.getParentSpecies ().getId ()
        );

        return dto;
    }

}
