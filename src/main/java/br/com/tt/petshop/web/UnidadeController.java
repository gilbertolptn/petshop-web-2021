package br.com.tt.petshop.web;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UnidadeController {

    private final static Logger LOG = LoggerFactory.getLogger(UnidadeController.class);

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping("/admin/unidades")
    public String listar(Model model) {

        //Unidade unidade = new Unidade(1L, "Cantinho do Pet", "Borges de Medeiros, 34");
        //model.addAttribute("unidades", Arrays.asList(unidade));

        List<Unidade> unidades = unidadeService.listar();
        model.addAttribute("unidades", unidades);

        return "unidades-page";
    }

    //@RequestMapping(method=RequestMethod.POST)
    @PostMapping("/actions/criar-unidade") // porque está POST no HTML
    public String criar(Unidade unidadeCriacao, RedirectAttributes attributes) {//Chega
        try {
            unidadeService.criar(unidadeCriacao);
            attributes.addFlashAttribute("mensagem", "Unidade criada com sucesso!");

        } catch (Exception e) {
            tratarErro(attributes, e);
        }

        //O spring disse que quando queremos redirecionar, use assim.
        // Ele vai mandar o browser ir para /admin/unidades
        return "redirect:/admin/unidades";
    }

    @PostMapping("/actions/atualizar-unidade")
    public String atualizar(Unidade unidadeAtualizacao, RedirectAttributes attributes){
        try {
            unidadeService.atualizar(unidadeAtualizacao);
            attributes.addFlashAttribute("mensagem", "Unidade atualizada com sucesso!");

        }catch (Exception e){
            tratarErro(attributes, e);
        }
        return "redirect:/admin/unidades";
    }

    private void tratarErro(RedirectAttributes attributes, Exception e){
        // e.printStackTrace(); - não usar no Spring!
        LOG.error("Ocorreu um erro", e);
        String erro = String.format("Ocorreu um erro: %s", e.getMessage());
        attributes.addFlashAttribute("erro", erro);
    }

}
