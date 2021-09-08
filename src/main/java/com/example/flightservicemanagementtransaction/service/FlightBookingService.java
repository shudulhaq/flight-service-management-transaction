package com.example.flightservicemanagementtransaction.service;

import com.example.flightservicemanagementtransaction.dto.FlightBookingRequest;
import com.example.flightservicemanagementtransaction.dto.FlightBookingResponse;
import com.example.flightservicemanagementtransaction.entity.PassengerInfo;
import com.example.flightservicemanagementtransaction.entity.PaymentInfo;
import com.example.flightservicemanagementtransaction.repository.PassengerInfoRepository;
import com.example.flightservicemanagementtransaction.repository.PaymentInfoRepository;
import com.example.flightservicemanagementtransaction.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingResponse bookFlightTicket(FlightBookingRequest request){
        FlightBookingResponse response = null;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingResponse("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }
}
