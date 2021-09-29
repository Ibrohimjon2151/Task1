package com.example.task1.peliod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class RoomPeliod  {
    private String hotelName;
    private String name;
    private int nummber;
    private double floor;
    private int size;
}
