package me.bokov.springboot.graphql.gql.mutation;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ServerMutation implements GraphQLResolver<ServerMutation> {

    public String getTest () {
        return "Test";
    }


}
