package com.tinqinacademy.hotel.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "user")
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne(targetEntity = Room.class)
    private Room room;

    private BigDecimal fullPrice;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToMany(targetEntity = Guest.class)
    private List<Guest> guests;
}
