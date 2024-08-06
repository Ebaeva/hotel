package com.tinqinacademy.hotel.persistence.entities;

import com.tinqinacademy.hotel.persistence.enums.BathroomTypes;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String roomNumber;

    private Integer roomFloor;

    private BigDecimal roomPrice;

    @Enumerated(EnumType.STRING)
    private BathroomTypes roomBathroomType;

    @ManyToMany
    private List<Bed> bedSizes;

    @CreationTimestamp
    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", updatable = false)
    private LocalDateTime updatedOn;
}