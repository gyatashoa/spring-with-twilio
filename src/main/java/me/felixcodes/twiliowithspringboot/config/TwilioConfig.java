package me.felixcodes.twiliowithspringboot.config;


import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {

    @Value("${config.twilio.account_sid}")
    public String TWILIO_ACCOUNT_SID;
    @Value("${config.twilio.auth_token}")
    public String TWILIO_AUTH_TOKEN;

    @Bean
    void initTwilio(){
        Twilio.init(TWILIO_ACCOUNT_SID,TWILIO_AUTH_TOKEN);
    }
}
