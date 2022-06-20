package me.felixcodes.twiliowithspringboot;

import lombok.extern.slf4j.Slf4j;
import me.felixcodes.twiliowithspringboot.config.TwilioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class TwilioWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwilioWithSpringBootApplication.class, args);
	}


}
