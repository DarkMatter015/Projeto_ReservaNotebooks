package reserva.notes.notes.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reserva.notes.notes.model.Agendamento;
import reserva.notes.notes.repo.RepoAgendamento;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/agenda")
public class ControllerAgendamento {

    @Autowired
    RepoAgendamento repoAgendamento;

    @GetMapping("/")
    public String fazOTreco(Model model) {
        // coloca a data no model
        Date data = Date.valueOf(LocalDate.now());
        model.addAttribute("data", data);

        // coloca a lista de agendamentos
        List<Agendamento> listaAgendamento = repoAgendamento.findBydataAgendada(data);
        model.addAttribute("listaAgendamento", listaAgendamento);

        // retorna a template
        return "lista-agendamento";
    }

    @PostMapping("/")
    public String filtrarAgendamento(@RequestParam("data") Date data,
                                     Model model) {
        // testa se a data é válida

        // atualiza o form com a nova data
        model.addAttribute("data", data);

        // coloca a lista de agendamentos
        List<Agendamento> listaAgendamento = repoAgendamento.findBydataAgendada(data);
        model.addAttribute("listaAgendamento", listaAgendamento);

        // retorna a template
        return "lista-agendamento";
    }
}