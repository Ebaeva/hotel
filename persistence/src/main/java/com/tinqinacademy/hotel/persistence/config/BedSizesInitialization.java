package com.tinqinacademy.hotel.persistence.config;

import com.tinqinacademy.hotel.persistence.entities.Bed;
import com.tinqinacademy.hotel.persistence.enums.Beds;
import com.tinqinacademy.hotel.persistence.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BedSizesInitialization implements ApplicationRunner {
    private final BedRepository bedRepository;

    @Autowired
    public BedSizesInitialization(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Bed> beds = bedRepository.findAll();

        List<Beds> databaseBeds = beds.stream()
                .map(Bed::getType)
                .toList();
        List<Beds> applicationBeds = Arrays.stream(Beds.values()).toList();

        List<Beds> differenceToBeAddedInDB = applicationBeds.stream()
                .filter(bedSize -> !databaseBeds.contains(bedSize))
                .toList();

        beds.addAll(differenceToBeAddedInDB.stream().map(x -> Bed.builder()
                .type(x)
                .capacity(x.getSize())
                .build())
                .toList());

        this.bedRepository.saveAll(beds);
    }
}