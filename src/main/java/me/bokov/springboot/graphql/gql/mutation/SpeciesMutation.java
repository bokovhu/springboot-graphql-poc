package me.bokov.springboot.graphql.gql.mutation;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.entity.Species;
import me.bokov.springboot.graphql.data.repository.SpeciesRepository;
import me.bokov.springboot.graphql.gql.dto.SpeciesDTO;
import me.bokov.springboot.graphql.gql.dto.SpeciesInputDTO;
import me.bokov.springboot.graphql.gql.mapper.SpeciesToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SpeciesMutation implements GraphQLResolver <SpeciesMutation> {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private SpeciesToDTO speciesToDTO;

    public SpeciesDTO getNew (SpeciesInputDTO species) {

        Species entity = new Species ();

        entity.setName (species.getName ());
        if (species.getParent () != null) {
            entity.setParentSpecies (
                    speciesRepository.getOne (species.getParent ())
            );
        }

        entity = speciesRepository.saveAndFlush (entity);

        return speciesToDTO.apply (entity);

    }

}
