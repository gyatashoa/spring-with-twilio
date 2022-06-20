package me.felixcodes.twiliowithspringboot.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.felixcodes.twiliowithspringboot.config.TwilioConfig;
import me.felixcodes.twiliowithspringboot.dto.SMSRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SMSService {

    final TwilioConfig twilioConfig;

    public void sendSms(SMSRequest smsRequest){
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(smsRequest.phoneNumber()),
                new com.twilio.type.PhoneNumber(twilioConfig.TWILIO_PHONE_NUMBER),
                "You have a new order request on, please open the app to check"
        ).create();
        var status = message.getStatus();
        log.info(status.name());
    }
}
