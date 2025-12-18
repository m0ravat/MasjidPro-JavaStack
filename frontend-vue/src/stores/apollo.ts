import { ApolloClient, InMemoryCache, HttpLink } from "@apollo/client/core";

export const apollo = new ApolloClient({
  link: new HttpLink({
    uri: "http://localhost:8080/graphql",
  }),
  cache: new InMemoryCache(),
});

