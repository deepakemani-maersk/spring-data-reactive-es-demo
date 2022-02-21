package com.maersk.springdatareactiveesdemo.service;

import com.maersk.springdatareactiveesdemo.model.BillOfLading;
import com.maersk.springdatareactiveesdemo.repository.BillOfLadingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;

import java.util.Set;

@Service
@AllArgsConstructor
public class BillOfLadingService {

    BillOfLadingRepository billOfLadingRepository;

    public Disposable doAllOperations(){
        return billOfLadingRepository.save(BillOfLading.builder().brandCode("MAEU").bookedByReference(Set.of("DEMO")).build())
                .doOnNext(System.out::println)
                .flatMap(billOfLading -> billOfLadingRepository.findById(billOfLading.getBillOfLadingId()))
                .doOnNext(System.out::println)
                .flatMap(billOfLading -> billOfLadingRepository.delete(billOfLading))
                .doOnNext(System.out::println)
                .flatMap(id -> billOfLadingRepository.count())
                .doOnNext(System.out::println)
                .subscribe();

    }

}
