package com.example.flightservicemanagementtransaction.controller;

import com.example.flightservicemanagementtransaction.dto.FlightBookingRequest;
import com.example.flightservicemanagementtransaction.dto.FlightBookingResponse;
import com.example.flightservicemanagementtransaction.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableTransactionManagement
public class BookingFlightController {

    @Autowired
    FlightBookingService service;

    @PostMapping("/bookingFlightTicket")
    public FlightBookingResponse bookingFlightTicket(@RequestBody FlightBookingRequest request){
        return service.bookFlightTicket(request);
    }
}
