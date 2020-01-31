package me.bokov.springboot.graphql.gql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.bokov.springboot.graphql.gql.mutation.AnimalMutation;
import me.bokov.springboot.graphql.gql.mutation.PersonMutation;
import me.bokov.springboot.graphql.gql.mutation.ServerMutation;
import me.bokov.springboot.graphql.gql.mutation.SpeciesMutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private PersonMutation personMutation;

    @Autowired
    private ServerMutation serverMutation;

    @Autowired
    private AnimalMutation animalMutation;

    @Autowired
    private SpeciesMutation speciesMutation;

    public PersonMutation person () {
        return personMutation;
    }

    public ServerMutation server () {
        return serverMutation;
    }

    public AnimalMutation animal () {
        return animalMutation;
    }

    public SpeciesMutation species () {
        return speciesMutation;
    }

}
