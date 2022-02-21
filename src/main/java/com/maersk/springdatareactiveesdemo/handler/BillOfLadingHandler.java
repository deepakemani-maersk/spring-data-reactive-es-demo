package com.maersk.springdatareactiveesdemo.handler;

import com.maersk.springdatareactiveesdemo.service.BillOfLadingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
@Slf4j
public class BillOfLadingHandler {

    private final BillOfLadingService billOfLadingService;

    public Mono<ServerResponse> handleAll(ServerRequest serverRequest) {

        billOfLadingService.doAllOperations();

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }


}
