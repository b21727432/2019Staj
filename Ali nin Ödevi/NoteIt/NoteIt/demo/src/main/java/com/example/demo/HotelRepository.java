package com.example.demo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotels,String> {
    List<Hotels> findByPricePerNightLessThan(int maxPrice);

    @Query(value = "{'address':?0}")
    List<Hotels> findByCity(String address);

}
