package me.felixcodes.twiliowithspringboot.controllers;


import me.felixcodes.twiliowithspringboot.dto.SMSRequest;
import me.felixcodes.twiliowithspringboot.services.SMSService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/sms")
public class SMSController {

    final SMSService smsService;

    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public void sms(@RequestBody SMSRequest smsRequest){
        smsService.sendSms(smsRequest);
    }

    @PostMapping("/media")
    public void mms(@RequestBody SMSRequest smsRequest,@RequestHeader String host) throws IOException {
        smsService.sendMMS(smsRequest,host);
    }

    @GetMapping(value = "/image",
        produces = MediaType.IMAGE_PNG_VALUE
    )
    public @ResponseBody byte[] getImage() throws IOException {
        return smsService.getImage();
    }
}
