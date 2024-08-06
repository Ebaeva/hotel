//package com.tinqinacademy.hotel.core.contracts;
//
//import com.tinqinacademy.hotel.api.operation.createroom.CreateRoomInput;
//import com.tinqinacademy.hotel.api.operation.createroom.CreateRoomOutput;
//import com.tinqinacademy.hotel.api.operation.deleteroom.DeleteRoomInput;
//import com.tinqinacademy.hotel.api.operation.editroom.EditRoomInput;
//import com.tinqinacademy.hotel.api.operation.editroom.EditRoomOutput;
//import com.tinqinacademy.hotel.persistence.entities.Bed;
//import com.tinqinacademy.hotel.persistence.entities.Room;
//import com.tinqinacademy.hotel.persistence.enums.BathroomTypes;
//import com.tinqinacademy.hotel.persistence.enums.BedSizes;
//import com.tinqinacademy.hotel.persistence.repository.BedRepository;
//import com.tinqinacademy.hotel.persistence.repository.RoomRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.convert.ConversionService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class AdminServiceImpl implements AdminService {
//    private final RoomRepository roomRepository;
//    private final BedRepository bedRepository;
//    private final ConversionService conversionService;
//
//
////    @Override
////    public void registerVisitor(VisitorRegisterInput visitorRegisterInput) {
////
////    }
////
////    @Override
////    public VisitorRegisterReportOutput registerVisitorReport(VisitorRegisterReportInput visitorRegisterReportInput) {
////        return VisitorRegisterReportOutput
////                .builder()
////                .startDate(LocalDate.now())
////                .endDate(LocalDate.now().plusDays(1))
////                .firstName("E")
////                .lastName("N")
////                .phoneNo("56")
////                .idCardNo("65")
////                .idCardValidity(LocalDate.now())
////                .idCardIssueAuthority("54")
////                .idCardIssueDate(LocalDate.now())
////                .build();
////    }
//
////    @Override
////    public CreateRoomOutput createRoom(CreateRoomInput createRoomInput) {
////        List<Beds> bedsList = createRoomInput.getBed().stream().map(Beds::getByCode).toList();
////        List<Bed> bedsExist = bedRepository.findAll().stream().filter(x -> bedsList.contains(x.getType())).toList();
////
////        Room room = Objects.requireNonNull(new RoomInputToRoomBuilder().convert(createRoomInput))
////                .bedSizes(bedsExist)
////                .build();
////
////        Room createdRoom = this.roomRepository.save(room);
////        return conversionService.convert(createdRoom, CreateRoomOutput.class);
////    }
//
//    @Override
//    public EditRoomOutput editRoom(@RequestBody EditRoomInput editRoomInput) {
//        Room roomToEdit = roomRepository.findByRoomNumber(editRoomInput.getId()).orElseThrow(() -> new RuntimeException("room not found"));
//
//        Room room = Room
//                .builder()
//                .id(roomToEdit.getId())
//                .roomNumber(editRoomInput.getRoomNo())
//                .roomFloor(editRoomInput.getFloor())
//                .roomPrice(editRoomInput.getPrice())
//                .bedSizes(editRoomInput.getBedSize().stream().map(bedType -> bedRepository.findByType(BedSizes.getByCode(bedType)).get()).toList())
//                .roomBathroomType(BathroomTypes.getByCode(editRoomInput.getBathroomType()))
//                .build();
//
//        roomRepository.save(room);
//
//        EditRoomOutput result = EditRoomOutput.builder().id(String.valueOf(room.getId())).build();
//
//        return result;
//    }
//
//
//    @Override
//    public CreateRoomOutput editRoom(CreateRoomInput createRoomInput) {
//        return null;
//    }
//
//    @Override
//    public void deleteRoom(DeleteRoomInput deleteRoomInput) {
//
//    }
//
////    @Override
////    public VisitorRegisterReportOutput visitorRegisterReportOutput(VisitorRegisterReportInput input) {
////        return null;
////    }
//
////    @Override
////    public VisitorRegisterReportOutput visitorRegisterReportOutput(VisitorRegisterReportInput input) {
////        log.info("Start VisitorRegisterReportOutput input: {}", input.toString());
////        VisitorRegisterReportOutput result = VisitorRegisterReportOutput
////                .builder()
////                .firstName(input.getFirstName())
////                .lastName(input.getLastName())
////                .startDate(input.getStartDate())
////                .endDate(input.getEndDate())
////                .phoneNo(input.getPhoneNo())
////                .idCardNo(input.getIdCardNo())
////                .idCardValidity(input.getIdCardValidity())
////                .idCardIssueAuthority(input.getIdCardIssueAuthority())
////                //.idCardIssueDate(LocalDate.now())
////                .idCardIssueDate(LocalDate.now().plusDays(1))
////                .build();
//    //List<User> users = userRepository.getAll();
//
////        VisitorRegisterReportOutput result = VisitorRegisterReportOutput.builder()
////                .firstName(users.get(0).getFirstName())
////                .lastName(users.get(0).getLastName())
////                .build();
////        log.info("End of VisitorRegisterReportOutput result: {}", result.toString());
//    // return result;
////    }
//
//    public Boolean checkIfRoomExists(String roomNumber) {
//        log.info("Checking if room {} exists", roomNumber);
//
//        return this.roomRepository.findAll().stream()
//                .anyMatch(x -> x.getRoomNumber().equalsIgnoreCase(roomNumber));
//
//    }
//
//    private List<Bed> getBedsByType(List<String> bedTypes) {
//        log.info("Start getBedsByCode input: {}", bedTypes);
//
//        List<BedSizes> bedsList = bedTypes
//                .stream()
//                .map(BedSizes::getByCode)
//                .toList();
//
//        List<Bed> beds = bedRepository
//                .findAll()
//                .stream()
//                .filter(bed -> bedsList.contains(bed.getType()))
//                .toList();
//
//        log.info("End getBedsByCode result: {}", beds);
//        return beds;
//    }
//
//    private String findRoomNumber(String roomInputRoomNo) {
//        Room idRoom = roomRepository.findByRoomNumber(roomInputRoomNo).get();
//        return idRoom.getId();
//    }
//
////    private Room findIdByRoomNumber(String roomId) {
////        Room roomIdExist = roomRepository.findRoomById(roomId).get();
////        return roomIdExist;
////    }
//
//
//}
