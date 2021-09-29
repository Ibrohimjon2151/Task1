package com.example.task1.contoller;

import com.example.task1.entity.Hotel;
import com.example.task1.entity.Room;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.HotelPeliod;
import com.example.task1.peliod.RoomPeliod;
import com.example.task1.service.HotelService;
import com.example.task1.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/room")
@RestController
public class RoomController {
@Autowired
    HotelService hotelService;

@Autowired
    RoomService roomService;

    @PostMapping()
    public ApiResponce add(@RequestBody RoomPeliod hotelPeliod){
        return roomService.addRoom(hotelPeliod);
    }

    @GetMapping()
    public List<Room> getHotelService() {
        return roomService.hotelList();
    }

    @GetMapping("/one/{id}")
    public ApiResponce hotelOneById(@PathVariable int id){
        return roomService.findById(id);
    }


    @PutMapping("/{id}")
    public ApiResponce updateById(@PathVariable int id , @RequestBody RoomPeliod hotelPeliod){
        return roomService.updateById(id , hotelPeliod);
    }


    @DeleteMapping("/{id}")
    public ApiResponce deleteById(@PathVariable int id){
        return roomService.deleteById(id);
    }
}
