package com.restaurant.booking.repository;

import com.restaurant.booking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long id);
    Optional<Reservation> findByName(String name);
    public List<Reservation> findAllByDate(String date);
    public List<Reservation> findByDateAndTime(String date, String time);
}
