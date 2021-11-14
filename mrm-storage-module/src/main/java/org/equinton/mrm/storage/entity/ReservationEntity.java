package org.equinton.mrm.storage.entity;

import lombok.*;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.storage.ReservationMapper;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "reservation")
@Builder
@Getter
public class ReservationEntity{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;
    @Column
    private LocalDate date;
    @Column
    private LocalTime startTime;
    @Column
    private LocalTime endTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
   // @ManyToOne(fetch = FetchType.LAZY)
    private String meetingRoom;

    public Reservation toReservation() {
        return null;// ReservationMapper.INSTANCE.toDomainObject(this);
    }
}
