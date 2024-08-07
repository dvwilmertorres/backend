package org.appmatch.msapigateway.implement;

import org.appmatch.msapigateway.repository.MstRouteManagerRepository;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class MstRouteManagerImpl {
    private final MstRouteManagerRepository _mstRouteManagerRepository;

    public MstRouteManagerImpl(MstRouteManagerRepository mstRouteManagerRepository) {
        _mstRouteManagerRepository = mstRouteManagerRepository;
    }

    @Bean
    public RouteDefinitionLocator dynamicRouteDefinitionLocator(MstRouteManagerRepository routeDefinitionRepository, RouteLocatorBuilder builder) {
        return () -> {
            Flux<RouteDefinition> routes = Flux.fromIterable(_mstRouteManagerRepository.findAll()).map(route -> {
                String uri = route.getProtocol()
                        + route.getUri()
                        + ":"
                        + route.getPort();
                RouteDefinition routeDefinition = new RouteDefinition();
                routeDefinition.setId(route.getPkid_mst_route_manager().toString());
                routeDefinition.setUri(URI.create(uri));
                //routeDefinition.setPredicates(convertPredicateFromString(route.getPredicates()));
                //routeDefinition.setFilters(convertFiltersFromString(route.getFilters()));
                return routeDefinition;
            });
            return routes;
        };
    }
    private List<FilterDefinition> convertFiltersFromString(String filtersString) {
        List<FilterDefinition> filters = new ArrayList<>();

        String[] filterStrings = filtersString.split(",");

        for (String filterString : filterStrings) {
            FilterDefinition filterDefinition = new FilterDefinition();
            filterDefinition.setName(filterString);

            filters.add(filterDefinition);
        }

        return filters;
    }
    private List<PredicateDefinition> convertPredicateFromString(String predicatesString) {
        List<PredicateDefinition> predicates = new ArrayList<>();

        String[] filterStrings = predicatesString.split(",");

        for (String predicateString : filterStrings) {
            PredicateDefinition filterDefinition = new PredicateDefinition();
            filterDefinition.setName(predicateString);

            predicates.add(filterDefinition);
        }

        return predicates;
    }

}
