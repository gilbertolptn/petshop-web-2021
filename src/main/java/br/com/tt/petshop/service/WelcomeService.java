package br.com.tt.petshop.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//@Service indica pro Spring que esse deve ser um Spring Bean
// o  Spring deve dar NEW nele e deixar disponível para usarmos
//Por padrão o ESCOPO Spring bean é Singleton (@ApplicationScope)
@Service
public class WelcomeService {

    public WelcomeService() {
        System.out.println("WelcomeService iniciado");
    }

    public String obtemVersao(){
        return String.format("v1.1.0-%s", LocalDateTime.now().toString());
    }
}
