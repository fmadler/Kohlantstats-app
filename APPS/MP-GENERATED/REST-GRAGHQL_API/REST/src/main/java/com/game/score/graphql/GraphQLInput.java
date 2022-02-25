package com.game.score.graphql;

import lombok.Data;

import java.util.Map;

@Data
public class GraphQLInput {
    String query;
    String variables;
    String mutation;
    String operationName;
    Map<String, Object> var;
}
