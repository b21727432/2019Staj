package com.example.demo;


import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRep;

    public HotelController(HotelRepository hotelRep) {
        this.hotelRep = hotelRep;
    }

    @GetMapping("/all")
    public List<Hotels> getAll(){
        List<Hotels> hotels = hotelRep.findAll();
        return hotels;
    }


    @PostMapping
    public void insertHotel(@RequestBody Hotels hotel, HttpServletRequest request) throws IOException {

        if(!request.getCookies()[0].getValue().equals(hotel.token)){
            return;
        }
        this.hotelRep.insert(hotel);
    }

    @PutMapping
    public void updateHotel(@RequestBody Hotels hotel){
        this.hotelRep.save(hotel);
    }

    @GetMapping("/{id}")
    public Optional<Hotels> findHotel(@PathVariable("id") String id){
        Optional<Hotels> hotel =  this.hotelRep.findById(id);
        return hotel;
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable("id") String id){
        this.hotelRep.deleteById(id);
        return "Hotel with that ID is deleted";
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotels> getLesserPrice(@PathVariable("maxPrice") int maxPrice){
        List<Hotels> hotels = this.hotelRep.findByPricePerNightLessThan(maxPrice);
        return hotels;
    }

    @GetMapping("/address/{address}")
    public List<Hotels> getByCity(@PathVariable("address") String address){
        List<Hotels> hotels = this.hotelRep.findByCity(address);
        return hotels;
    }

    @GetMapping("/file")
    public String sendFile(@RequestParam(value="inputFile") File inputFile) {
        try {
            String var = "";
            int lenght = inputFile.toString().length();
            var += inputFile.toString().charAt(lenght - 3);
            var += inputFile.toString().charAt(lenght - 2);
            var += inputFile.toString().charAt(lenght - 1);
            if (var.equals("jpg") || var.equals("png")) {
       //       ImageIO.write(image, "jpg", f);
                inputFile.createNewFile();
                return "You are In WhiteList";
            } else {
                return "You are In Blacklist";
            }
        }catch (Exception e){
            return e.getLocalizedMessage();
        }
    }
}
