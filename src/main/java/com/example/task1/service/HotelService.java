package com.example.task1.service;

import com.example.task1.entity.Hotel;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.HotelPeliod;
import com.example.task1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public ApiResponce addHotel(HotelPeliod hotel){
        Hotel hotelAdd = new Hotel();
        hotelAdd.setName(hotel.getName());
        Hotel save = hotelRepository.save(hotelAdd);
        return new ApiResponce(true , save);
    }

    public List<Hotel> hotelList(){
        return hotelRepository.findAll();
    }


    public ApiResponce findById(int id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        return optionalHotel.map(hotel -> new ApiResponce(true, hotel)).orElseGet(() -> new ApiResponce(false, "Not found"));
    }

    public ApiResponce updateById(int id , HotelPeliod hotelPeliod) {
        if (hotelRepository.findById(id).isPresent()) {
            Hotel repositoryById = hotelRepository.getById(id);
            repositoryById.setName(hotelPeliod.getName());
            hotelRepository.save(repositoryById);
            return new  ApiResponce(true ,repositoryById);
        }
        return new ApiResponce(false , "Not Found");
    }

    public ApiResponce deleteById(int id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return new ApiResponce(true , "deleted");
        }
        return new ApiResponce(false , "Not found");
    }
}
