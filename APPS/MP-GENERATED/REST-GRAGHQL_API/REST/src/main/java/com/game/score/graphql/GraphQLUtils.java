package com.game.score.graphql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class GraphQLUtils {
    public static GraphQLInput getGraphQLInput (String input) {
        GraphQLInput graphqlInput = new GraphQLInput();
        Gson gson = new GsonBuilder().create();
        Map<String,Object> jsonMap = (input!=null)?gson.fromJson(input, Map.class):new HashMap();
        graphqlInput.setQuery((String)jsonMap.get("query"));
        graphqlInput.setVar((Map<String,Object>)jsonMap.get("variables"));
        return graphqlInput;
    }
}
