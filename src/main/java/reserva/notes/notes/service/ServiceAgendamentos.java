package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelAgendamentos;
import reserva.notes.notes.repo.RepoAgendamentos;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAgendamentos {
    @Autowired
    private RepoAgendamentos repoAgendamentos;
    public ModelAgendamentos salvarAgendamentos(ModelAgendamentos agendamentos){
        return repoAgendamentos.save(agendamentos);
    }
    public List<ModelAgendamentos> listarAgendamentos(){
        return repoAgendamentos.findAll();
    }

    public ModelAgendamentos buscarAgendamentosPorId(Long id)throws RegistroNaoEncontradoException {
        Optional<ModelAgendamentos> opt = repoAgendamentos.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RegistroNaoEncontradoException("Agendamento com id : " + id + " não existe");
        }
    }

    public void apagarAgendamentos(Long id) throws RegistroNaoEncontradoException {
        ModelAgendamentos agendamento = buscarAgendamentosPorId(id);
        repoAgendamentos.delete(agendamento);
    }

}
