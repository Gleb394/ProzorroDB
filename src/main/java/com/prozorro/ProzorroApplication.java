package com.prozorro;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prozorro.Model.Tender;
import com.prozorro.service.TenderService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ProzorroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProzorroApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TenderService tenderService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Tender>> typeReference = new TypeReference<List<Tender>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/prozorro.json");
            try {
                List<Tender> tenders = mapper.readValue(inputStream, typeReference);
                tenderService.save(tenders);
            } catch (IOException e) {

            }
        };
    }
}