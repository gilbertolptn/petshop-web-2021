package br.com.tt.petshop.web;

import br.com.tt.petshop.service.WelcomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
//@RequestScope - isso faria criar um bean a cada chamada!
public class WelcomeController {

    private final WelcomeService welcomeService; //final indica que só pode ser inicializado 1 vez (no construtor)

    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
        System.out.println("WelcomeController iniciado");
    }

    /*
        Model é criado sozinho quando chamamos o endereço desse método /
     */
    @GetMapping("/")
    public String ola(Model model){
        String versao = welcomeService.obtemVersao();
        model.addAttribute("versao", versao);

        List<String> notas = Arrays.asList(
                "Criado Controller Welcome",
                "Criada página inicial",
                "Usado o Thymeleaf");

        model.addAttribute("notas", notas);

        return "welcome-page";//Nome do arquivo HTML
    }
}
