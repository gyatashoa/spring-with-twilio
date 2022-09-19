package me.felixcodes.twiliowithspringboot.controllers;


import me.felixcodes.twiliowithspringboot.dto.SMSRequest;
import me.felixcodes.twiliowithspringboot.services.SMSService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
public class SMSController {

    final SMSService smsService;

    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/acceptResponse")
    public void smsAcceptResponse(@RequestBody SMSRequest smsRequest){
        smsService.sendResponseSms(smsRequest);
    }

    @PostMapping("/request")
    public void sendRequest(@RequestBody SMSRequest smsRequest){
        smsService.sendRequestSms(smsRequest);
    }



    @PostMapping("/endResponse")
    public void smsDecline(@RequestBody SMSRequest smsRequest){
        smsService.sendDeclineSms(smsRequest);
    }


    @PostMapping("/rideEnd")
    public void smsEnded(@RequestBody SMSRequest smsRequest){
        smsService.sendRideEnded(smsRequest);
    }



}
