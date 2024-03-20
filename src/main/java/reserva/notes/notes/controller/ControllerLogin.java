package reserva.notes.notes.controller;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerLogin {

    @PostMapping("/login")
    public String validaLogin(@Param("matricula") String matricula, @Param("senha") String senha,
                              Model model){

        if (matricula.equals("usuario") && senha.equals("senha")) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Credenciais inválidas. Por favor, tente novamente.");
            return "/index";
        }
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "/home";
    }

}
