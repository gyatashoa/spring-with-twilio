package me.felixcodes.twiliowithspringboot.controllers;


import lombok.AllArgsConstructor;
import me.felixcodes.twiliowithspringboot.dto.SMSRequest;
import me.felixcodes.twiliowithspringboot.services.SMSService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
@AllArgsConstructor
public class SMSController {

    final SMSService smsService;

    @PostMapping("/send")
    public void sms(@RequestBody SMSRequest smsRequest){
        smsService.sendSms(smsRequest);
    }
}
