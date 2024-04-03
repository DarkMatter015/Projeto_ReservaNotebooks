package reserva.notes.notes.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelCategoria;
import reserva.notes.notes.service.ServiceCategoria;
import reserva.notes.notes.service.ServiceCategoria;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class ControllerCategoria {

    @Autowired
    ServiceCategoria serviceCategoria;

    @GetMapping("/")
    public String listarCategorias(Model model) {
        List<ModelCategoria> notebooks = serviceCategoria.listarCategorias();
        model.addAttribute("listaCategorias",notebooks);
        return "/lista-notebooks";
    }

    @GetMapping("/novo")
    public String novoCategoria(Model model) {
        ModelCategoria categoria = new ModelCategoria();
        model.addAttribute("objetoCategoria",categoria);
        return "/edita-categoria";
    }

    @PostMapping("/gravar")
    public String gravarCategoria(@ModelAttribute("novoCategoria") @Valid ModelCategoria categoria,
                                 BindingResult erros,
                                 RedirectAttributes attributes) {
        if(erros.hasErrors()) {
            return "/novo-categoria";
        }
        serviceCategoria.salvarCategoria(categoria);
        attributes.addFlashAttribute("mensagem", "Categoria salvo com sucesso!");
        return "redirect:/novo";
    }

    @GetMapping("/apagar/{id}")
    public String apagarCategoria(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            serviceCategoria.apagarCategoria(id);
        } catch (RegistroNaoEncontradoException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }


    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") long id, RedirectAttributes attributes,
                             Model model) {
        try {
            ModelCategoria categoria = serviceCategoria.buscarCategoriaPorId(id);
            model.addAttribute("objetoCategoria", categoria);
            return "/alterar-categoria";
        } catch (RegistroNaoEncontradoException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }

    @PostMapping("/editar/{id}")
    public String editarCategoria(@PathVariable("id") long id,
                                 @ModelAttribute("objetoCategoria") @Valid ModelCategoria categoria,
                                 BindingResult erros) {
        if (erros.hasErrors()) {
            categoria.setId(id);
            return "/alterar-categoria";
        }
        serviceCategoria.salvarCategoria(categoria);
        return "redirect:/";
    }

}
