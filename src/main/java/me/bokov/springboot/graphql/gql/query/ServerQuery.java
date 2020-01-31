package me.bokov.springboot.graphql.gql.query;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ServerQuery implements GraphQLResolver<ServerQuery> {

    public String info () {
        return "Hi";
    }

}
