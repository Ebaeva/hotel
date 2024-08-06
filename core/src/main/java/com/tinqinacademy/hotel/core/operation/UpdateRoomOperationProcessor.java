package com.tinqinacademy.hotel.core.operation;

import com.tinqinacademy.hotel.api.errors.Errors;
import com.tinqinacademy.hotel.api.operation.updateroom.UpdateRoomInput;
import com.tinqinacademy.hotel.api.operation.updateroom.UpdateRoomOperation;
import com.tinqinacademy.hotel.api.operation.updateroom.UpdateRoomOutput;
import com.tinqinacademy.hotel.core.errorsmapper.ErrorMapper;
import io.vavr.control.Either;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateRoomOperationProcessor extends BaseOperationProcessor implements UpdateRoomOperation {
    protected UpdateRoomOperationProcessor(ConversionService conversionService, Validator validator, ErrorMapper errorMapper) {
        super(conversionService, validator, errorMapper);
    }

    @Override
    public Either<Errors, UpdateRoomOutput> process(UpdateRoomInput input) {
        return null;
    }
//    private final RoomRepository roomRepository;
//    private final BedRepository bedRepository;
//    private final ObjectMapper objectMapper;
//
//    protected UpdateRoomOperationProcessor(ConversionService conversionService, Validator validator, ErrorMapper errorMapper, RoomRepository roomRepository, BedRepository bedRepository, ObjectMapper objectMapper) {
//        super(conversionService, validator, errorMapper);
//        this.roomRepository = roomRepository;
//        this.bedRepository = bedRepository;
//        this.objectMapper = objectMapper;
//    }
//
//    @Override
//    public Either<Errors, UpdateRoomOutput> process(UpdateRoomInput input) {
//        return Try.of(() -> {
//
//
//                    Room existingRoom = roomRepository.findById(UUID.fromString(input.getId()))
//                            .orElseThrow(() -> new RoomNotFoundException(input.getId()));
//
//
//                    Room updatedRoom = Room.builder()
//                            .roomPrice(input.getPrice())
//                            .roomNumber(input.getRoomN())
//                            .roomFloor(input.getFloor())
//                            .roomBathroomType(BathroomTypes.getByCode(input.getBathroomType()))
//                            .bedSizes(mapBedsFromStrings(input.getBedSize()))
//                            .build();
//
//
//                    JsonNode existingRoomNode = objectMapper.valueToTree(existingRoom);
//                    JsonNode inputRoomNode = objectMapper.valueToTree(updatedRoom);
//                    //JsonMergePatch jsonMergePatchInput = JsonMergePatch.fromJson(inputRoomNode);
//                    Room updatedResultRoom = objectMapper.treeToValue(jsonMergePatchInput.apply(existingRoomNode), Room.class);
//                    roomRepository.save(updatedResultRoom);
//
//                    UpdateRoomOutput result = UpdateRoomOutput.builder().id(String.valueOf(updatedResultRoom.getId())).build();
//
//                    log.info("End updateRoom result: {}", result);
//                    return result;
//
//                }).toEither()
//                .mapLeft(throwable -> Match(throwable).of(
//                        Case($(Predicates.instanceOf(RoomNotFoundException.class)), errorMapper::mapErrors),
//                        Case($(), errorMapper::mapErrors)
//                ));
//    }
//    private List<Bed> mapBedsFromStrings(List<String> bedStrings) {
//        return bedStrings == null || bedStrings.isEmpty()
//                ? null
//                : bedStrings
//                .stream()
//                .map(Beds::getByCode)
//                .map(bedRepository::findByType)
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .toList();
//    }
}