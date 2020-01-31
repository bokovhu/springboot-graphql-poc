package me.bokov.springboot.graphql.gql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.repository.SpeciesRepository;
import me.bokov.springboot.graphql.gql.dto.SpeciesDTO;
import me.bokov.springboot.graphql.gql.mapper.SpeciesToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class SpeciesResolver implements GraphQLResolver<SpeciesDTO> {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private SpeciesToDTO speciesToDTO;

    public SpeciesDTO getParent (SpeciesDTO species) {

        if (species.getParentSpeciesId () != null) {
            return speciesToDTO.apply (
                    speciesRepository.getOne (species.getParentSpeciesId ())
            );
        }

        return null;
    }

    public List<SpeciesDTO> getSubSpecies (SpeciesDTO species) {
        return speciesRepository.findAllByParentSpecies_Id (Long.valueOf (species.getId ()))
                .stream ().map (speciesToDTO)
                .collect (Collectors.toList ());
    }

}
