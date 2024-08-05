package com.tinqinacademy.hotel.core.operation;

import com.tinqinacademy.hotel.api.errors.Errors;
import com.tinqinacademy.hotel.api.operation.checkavailableroom.CheckAvailableRoomInput;
import com.tinqinacademy.hotel.api.operation.checkavailableroom.CheckAvailableRoomOperation;
import com.tinqinacademy.hotel.api.operation.checkavailableroom.CheckAvailableRoomOutput;
import com.tinqinacademy.hotel.core.errorsmapper.ErrorMapper;
import io.vavr.control.Either;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CheckAvailableRoomOperationProcessor extends BaseOperationProcessor implements CheckAvailableRoomOperation {
    protected CheckAvailableRoomOperationProcessor(ConversionService conversionService, Validator validator, ErrorMapper errorMapper) {
        super(conversionService, validator, errorMapper);
    }

    @Override
    public Either<Errors, CheckAvailableRoomOutput> process(CheckAvailableRoomInput input) {
        return null;
    }
//    private final RoomRepository roomRepository;
//
//    protected CheckAvailableRoomOperationProcessor(ConversionService conversionService, Validator validator, ErrorMapper errorMapper, RoomRepository roomRepository) {
//        super(conversionService, validator, errorMapper);
//        this.roomRepository = roomRepository;
//    }
//
//    @Override
//    public Either<Errors, CheckAvailableRoomOutput> process(CheckAvailableRoomInput input) {
//        return Try.of(() -> {
//                    log.info("Processing GetRoomFreeRooms");
//
//                    List<UUID> freeRoomsIds = roomRepository.findAllFreeRoomsByStartAndEndDate(input.getStartDate(), input.getEndDate());
//                    if (freeRoomsIds.isEmpty()) {
//                        throw new RoomNotFoundException("No Ids found");
//                    }
//
//                    List<Room> freeRooms = roomRepository.findAllById(freeRoomsIds);
//                    Integer requiredCapacity = getTotalCapacity(input.getBedSizes());
//
//                    List<Room> freeRoomsMatchingCapacity = freeRooms.stream()
//                            .filter(room -> {
//                                List<String> bedSizesLambda = room.getBedSizes()
//                                        .stream()
//                                        .map(Bed::getType)
//                                        .map(Beds::toString)
//                                        .toList();
//                                Integer roomCapacity = getTotalCapacity(bedSizesLambda);
//                                return roomCapacity >= requiredCapacity;
//                            })
//                            .toList();
//
//                    List<String> resultingIds = freeRoomsMatchingCapacity
//                            .stream()
//                            .map(Room::getId)
//                            .map(UUID::toString)
//                            .toList();
//                    CheckAvailableRoomOutput result = CheckAvailableRoomOutput
//                            .builder()
//                            .ids(resultingIds)
//                            .build();
//
//
//                    log.info("End of GetRoomFreeRooms");
//                    return result;
//                }).toEither()
//                .mapLeft(throwable -> Match(throwable).of(
//                        Case($(Predicates.instanceOf(RoomNotFoundException.class)), errorMapper::mapErrors),
//                        Case($(), errorMapper::mapErrors)
//                ));
//
//    }
//    private Integer getTotalCapacity(List<String> input) {
//        Integer totalCapacity = 0;
//        List<Beds> bedSizes = input.stream()
//                .map(Beds::getByCode)
//                .toList();
//
//        for (Beds bedSize : bedSizes) {
//            totalCapacity += bedSize.getCapacity();
//        }
//        return totalCapacity;
//    }
}
