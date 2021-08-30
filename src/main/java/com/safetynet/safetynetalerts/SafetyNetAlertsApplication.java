package com.safetynet.safetynetalerts;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.JsonReadFileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SafetyNetAlertsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafetyNetAlertsApplication.class, args);
    }


}
