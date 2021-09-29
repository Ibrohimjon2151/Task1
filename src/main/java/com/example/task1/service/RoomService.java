package com.example.task1.service;

import com.example.task1.entity.Hotel;
import com.example.task1.entity.Room;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.HotelPeliod;
import com.example.task1.peliod.RoomPeliod;
import com.example.task1.repository.HotelRepository;
import com.example.task1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;


    public ApiResponce addRoom(RoomPeliod roomPeliod){
        Hotel hotelAdd = new Hotel();
        hotelAdd.setName(roomPeliod.getHotelName());
        Hotel save = hotelRepository.save(hotelAdd);

        Room room = new Room();
        room.setHotel(save);
        room.setNummber(roomPeliod.getNummber());
        room.setFloor(roomPeliod.getFloor());
        room.setNummber(roomPeliod.getNummber());
        roomRepository.save(room);

        return new ApiResponce(true , room);
    }

    public List<Room> hotelList(){
        return roomRepository.findAll();
    }


    public ApiResponce findById(int id) {
        Optional<Room> optionalHotel = roomRepository.findById(id);
        return optionalHotel.map(room -> new ApiResponce(true, room)).orElseGet(() -> new ApiResponce(false, "Not found"));
    }

    public ApiResponce updateById(int id , RoomPeliod hotelPeliod) {
        if (roomRepository.findById(id).isPresent()) {
            Room repositoryById = roomRepository.getById(id);
            repositoryById.setFloor(hotelPeliod.getFloor());
            repositoryById.setSize(hotelPeliod.getSize());
            repositoryById.setNummber(hotelPeliod.getNummber());
            roomRepository.save(repositoryById);
            return new  ApiResponce(true ,repositoryById);
        }
        return new ApiResponce(false , "Not Found");
    }

    public ApiResponce deleteById(int id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return new ApiResponce(true , "deleted");
        }
        return new ApiResponce(false , "Not found");
    }
}
