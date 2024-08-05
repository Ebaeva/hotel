package com.tinqinacademy.hotel.persistence.repository;

import com.tinqinacademy.hotel.persistence.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    List<Reservation> findAllByRoomId(String room_id);
}
