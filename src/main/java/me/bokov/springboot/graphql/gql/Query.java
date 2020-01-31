package me.bokov.springboot.graphql.gql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.bokov.springboot.graphql.gql.query.AnimalQuery;
import me.bokov.springboot.graphql.gql.query.PersonQuery;
import me.bokov.springboot.graphql.gql.query.ServerQuery;
import me.bokov.springboot.graphql.gql.query.SpeciesQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private PersonQuery personQuery;

    @Autowired
    private ServerQuery serverQuery;

    @Autowired
    private AnimalQuery animalQuery;

    @Autowired
    private SpeciesQuery speciesQuery;

    public PersonQuery person () {
        return personQuery;
    }

    public ServerQuery server () {
        return serverQuery;
    }

    public AnimalQuery animal () {
        return animalQuery;
    }

    public SpeciesQuery species () {
        return speciesQuery;
    }

}
