package com.maersk.springdatareactiveesdemo.router;

import com.maersk.springdatareactiveesdemo.handler.BillOfLadingHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Component
@RequiredArgsConstructor
public class BillOfLadingServiceRouter {

    @Bean
    public RouterFunction<ServerResponse> route(BillOfLadingHandler billOfLadingHandler) {
        return RouterFunctions.route(GET("/billOfLading"), billOfLadingHandler::handleAll);
    }

}
