package com.system.hotel.Controller;

import com.system.hotel.model.Room;
import com.system.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    // Ensure BOTH {hotelId} in path AND Long hotelId in parameter match
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Room>> getRoomsByHotelId(@PathVariable Long hotelId) { // <--- MUST be hotelId here
        System.out.println("Fetching rooms for hotelId: " + hotelId); // Use hotelId
        // Ensure repository method is also correct (findByHotel_Id was recommended)
        List<Room> rooms = roomRepository.findByHotel_Id(hotelId); // Use hotelId
        return ResponseEntity.ok(rooms);
    }

}