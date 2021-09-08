package com.example.flightservicemanagementtransaction.dto;

import com.example.flightservicemanagementtransaction.entity.PassengerInfo;
import com.example.flightservicemanagementtransaction.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
