package reserva.notes.notes.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelAgendamento;
import reserva.notes.notes.service.ServiceAgendamento;

import java.util.List;

@Controller
@RequestMapping("/agendamento")
public class ControllerAgendamento {
    @Autowired
    ServiceAgendamento agendamentoServico;

    @GetMapping("/")
    public String listarAgendamento(Model model) {
        List<ModelAgendamento> agendamento = agendamentoServico.listarAgendamentos();
        model.addAttribute("listaAgendamento",agendamento);
        return "/lista-agendamento";
    }
    @GetMapping("/novo")
    public String novoAgendamento(Model model) {
        ModelAgendamento agendamento = new ModelAgendamento();
        model.addAttribute("objetoAgendamento",agendamento);
        return "/edita-agendamento";
    }

    @PostMapping("/gravar")
    public String gravarAgendamento(@ModelAttribute("novoAgendamento") @Valid ModelAgendamento agendamento,
                                 BindingResult erros,
                                 RedirectAttributes attributes) {
        if(erros.hasErrors()) {
            return "/edita-agendamento";
        }
        agendamentoServico.salvarAgendamento(agendamento);
        attributes.addFlashAttribute("mensagem", "Agendamento salvo com sucesso!");
        return "redirect:/";
    }

    @GetMapping("/apagar/{id}")
    public String apagarAgendamento(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            agendamentoServico.apagarAgendamento(id);
        } catch (RegistroNaoEncontradoException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") long id, RedirectAttributes attributes,
                             Model model) {
        try {
            ModelAgendamento agendamento = agendamentoServico.buscarAgendamentoPorId(id);
            model.addAttribute("objetoAgendamento", agendamento);
            return "/edita-agendamento";
        } catch (RegistroNaoEncontradoException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }

    @PostMapping("/editar/{id}")
    public String editarAgendamento(@PathVariable("id") long id,
                                 @ModelAttribute("objetoAgendamento") @Valid ModelAgendamento agendamento,
                                 BindingResult erros) {
        if (erros.hasErrors()) {
            agendamento.setId(id);
            return "/edita-agendamento";
        }
        agendamentoServico.salvarAgendamento(agendamento);
        return "redirect:/";
    }

}
