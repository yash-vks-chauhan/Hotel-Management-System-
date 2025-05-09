package com.system.hotel.repository;

import com.system.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("SELECT h FROM Hotel h JOIN FETCH h.rooms WHERE h.id = :hotelId")
    Hotel findHotelWithRooms(@Param("hotelId") Long hotelId);
}
