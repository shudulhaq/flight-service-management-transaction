package com.example.flightservicemanagementtransaction.dto;

import com.example.flightservicemanagementtransaction.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingResponse {

    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
