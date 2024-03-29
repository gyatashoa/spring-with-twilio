package me.felixcodes.twiliowithspringboot.services;

import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import me.felixcodes.twiliowithspringboot.config.TwilioConfig;
import me.felixcodes.twiliowithspringboot.dto.SMSRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

@Service
@Slf4j
public class SMSService {

    final TwilioConfig twilioConfig;

    public SMSService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    public void sendRequestSms(SMSRequest smsRequest){
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(smsRequest.getPhoneNumber()),
                new com.twilio.type.PhoneNumber(twilioConfig.TWILIO_PHONE_NUMBER),
                String.format("Dear %s,You have a new order request, please open the app to check",smsRequest.getName())
        ).create();
        Message.Status status = message.getStatus();
        log.info(status.name());
    }


    public void sendRideEnded(SMSRequest smsRequest){
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(smsRequest.getPhoneNumber()),
                new com.twilio.type.PhoneNumber(twilioConfig.TWILIO_PHONE_NUMBER),
                String.format("Dear %s,Your ride has ended,Thank you for using our app.",smsRequest.getName())
        ).create();
        Message.Status status = message.getStatus();
        log.info(status.name()); 
    }

    public void sendDeclineSms(SMSRequest smsRequest){
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(smsRequest.getPhoneNumber()),
                new com.twilio.type.PhoneNumber(twilioConfig.TWILIO_PHONE_NUMBER),
                String.format("Dear %s,Your order request has been cancelled",smsRequest.getName())
        ).create();
        Message.Status status = message.getStatus();
        log.info(status.name());
    }

    public void sendResponseSms(SMSRequest smsRequest) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(smsRequest.getPhoneNumber()),
                new com.twilio.type.PhoneNumber(twilioConfig.TWILIO_PHONE_NUMBER),
                String.format("Dear %s,Your order request has been accepted",smsRequest.getName())
        ).create();
        Message.Status status = message.getStatus();
        log.info(status.name());
    }

//    public void sendMMS(SMSRequest smsRequest, String host) throws IOException {
//        Resource resource = new ClassPathResource("pic.png");
//        Message message = Message.creator(
//                new com.twilio.type.PhoneNumber(smsRequest.getPhoneNumber()),
//                new com.twilio.type.PhoneNumber(twilioConfig.TWILIO_PHONE_NUMBER),
//                "You have a new order request on, please open the app to check"
//        ).setMediaUrl(
//                URI.create("https://freeiconshop.com/wp-content/uploads/edd/image-solid.png")
//        ).create();
//        Message.Status status = message.getStatus();
//        log.info(status.name());
//    }
//
//    public byte[] getImage() throws IOException {
//        Resource resource = new ClassPathResource("pic.png");
//        return IOUtils.toByteArray(resource.getInputStream());
//    }
}
