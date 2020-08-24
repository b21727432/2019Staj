package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserSeeder implements CommandLineRunner { // this starts before the application starts
    // this is where i seed the hotels into database ( onceden koymak istediklerin icin)

    private HotelRepository hotelRep;

    @Autowired
    public UserSeeder(HotelRepository hotelRep) {
        this.hotelRep = hotelRep;
    }




    @Override
    public void run(String...strings) throws Exception{

        Hotels sheraton = new Hotels(
                "Sheraton",
                250,
                "Ankara",
                5
        );
        Hotels hilton = new Hotels(
                "Hilton",
                200,
                "Ankara",
                5
        );




        this.hotelRep.deleteAll();



        this.hotelRep.save(sheraton);
        this.hotelRep.save(hilton);






    }

}

