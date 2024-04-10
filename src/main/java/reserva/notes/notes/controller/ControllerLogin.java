package reserva.notes.notes.controller;



import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelLogin;
import reserva.notes.notes.service.ServiceLogin;

import java.util.List;

@Controller
public class ControllerLogin {

    @Autowired
    ServiceLogin serviceLogin;

    @GetMapping("/")
    public String getLogin(){
        return "index";
    }
    @PostMapping("/")
    public String validaLogin(@RequestParam("matricula") String matricula, @RequestParam("senha") String senha,
                              Model model, HttpSession session){

        session.setAttribute("usuario", ServiceLogin.validaLogin(matricula, senha));

        if (session.getAttribute("usuario") != null) {
            return "redirect:/usuario/";
        } else {
            model.addAttribute("error", "Credenciais inválidas. Por favor, tente novamente.");
            return "/index";
        }
    }

    @GetMapping("/usuario/")
    public String listarLogin(Model model) {
        List<ModelLogin> usuario = serviceLogin.listarLogin();
        model.addAttribute("listaUsuarios",usuario);
        return "/lista-login";
    }

    @GetMapping("/usuario/novo")
    public String novoLogin(Model model) {
        ModelLogin login = new ModelLogin();
        model.addAttribute("objetoLogin",login);
        return "/edita-login";
    }

    @PostMapping("/usuario/gravar")
    public String gravarLogin(@ModelAttribute("novoLogin") @Valid ModelLogin login,
                                 BindingResult erros,
                                 RedirectAttributes attributes) {
        if(erros.hasErrors()) {
            return "/edita-login";
        }
        serviceLogin.salvarLogin(login);
        attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!");
        return "redirect:/usuario/";
    }

    @GetMapping("/usuario/apagar/{id}")
    public String apagarLogin(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            serviceLogin.apagarLogin(id);
        } catch (RegistroNaoEncontradoException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/usuario/";
    }


    @GetMapping("/usuario/editar/{id}")
    public String editarLogin(@PathVariable("id") long id, RedirectAttributes attributes,
                             Model model) {
        try {
            ModelLogin login = serviceLogin.buscarLoginPorId(id);
            model.addAttribute("objetoLogin", login);
            return "/edita-login";
        } catch (RegistroNaoEncontradoException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/usuario/";
    }

    @PostMapping("/usuario/editar/{id}")
    public String editarLogin(@PathVariable("id") long id,
                                 @ModelAttribute("objetoLogin") @Valid ModelLogin login,
                                 BindingResult erros) {
        if (erros.hasErrors()) {
            login.setId(id);
            return "/edita-login";
        }
        serviceLogin.salvarLogin(login);
        return "redirect:/usuario/";
    }

}
