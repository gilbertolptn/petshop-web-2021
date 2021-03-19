package br.com.tt.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetshopWebApplication {

    private String algo;

    public static void main(String[] args) {
        SpringApplication.run(PetshopWebApplication.class, args);
    }
}
