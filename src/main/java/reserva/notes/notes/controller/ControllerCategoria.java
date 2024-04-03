package reserva.notes.notes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class ControllerCategoria {

    @GetMapping({"", "/"})
    public String listaCategoria(Model model){
        return "listaCategorias";
    }



}
