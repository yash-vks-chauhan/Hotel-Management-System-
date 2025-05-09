package com.system.hotel.repository;

import com.system.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    // *** CORRECTED METHOD NAME ***
    // Find rooms where the 'Id' property of the 'hotel' object matches the given hotelId
    List<Room> findByHotel_Id(Long hotelId); // Changed parameter name for clarity too

}