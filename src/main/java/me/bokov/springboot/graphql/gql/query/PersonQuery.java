package me.bokov.springboot.graphql.gql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.repository.PersonRepository;
import me.bokov.springboot.graphql.gql.dto.PersonDTO;
import me.bokov.springboot.graphql.gql.mapper.PersonToPersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class PersonQuery implements GraphQLResolver <PersonQuery> {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonToPersonDTO personToPersonDTO;

    public PersonDTO getById (Long id) {
        return personToPersonDTO.apply (
                personRepository.getOne (id)
        );
    }

    public List <PersonDTO> getAll () {
        return personRepository.findAll ()
                .stream ().map (personToPersonDTO)
                .collect(Collectors.toList());
    }

}
