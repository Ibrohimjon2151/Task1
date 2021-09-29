package com.example.task1.contoller;

import com.example.task1.entity.Hotel;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.HotelPeliod;
import com.example.task1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/hotel")
@RestController
public class HotelController {
@Autowired
    HotelService hotelService;

    @PostMapping()
    public ApiResponce add(@RequestBody HotelPeliod hotelPeliod){
        return hotelService.addHotel(hotelPeliod);
    }

    @GetMapping()
    public List<Hotel> getHotelService() {
        return hotelService.hotelList();
    }

    @GetMapping("/one/{id}")
    public ApiResponce hotelOneById(@PathVariable int id){
        return hotelService.findById(id);
    }


    @PutMapping("/{id}")
    public ApiResponce updateById(@PathVariable int id , @RequestBody HotelPeliod hotelPeliod){
        return hotelService.updateById(id , hotelPeliod);
    }


    @DeleteMapping("/{id}")
    public ApiResponce deleteById(@PathVariable int id){
        return hotelService.deleteById(id);
    }
}
