package me.bokov.springboot.graphql.gql.query;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.repository.SpeciesRepository;
import me.bokov.springboot.graphql.gql.dto.SpeciesDTO;
import me.bokov.springboot.graphql.gql.mapper.SpeciesToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class SpeciesQuery implements GraphQLResolver <SpeciesQuery> {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private SpeciesToDTO speciesToDTO;

    public SpeciesDTO getById (Long id) {
        return speciesToDTO.apply (
                speciesRepository.getOne (id)
        );
    }

    public List <SpeciesDTO> getAll () {
        return speciesRepository.findAll ()
                .stream ().map (speciesToDTO)
                .collect(Collectors.toList());
    }

}
