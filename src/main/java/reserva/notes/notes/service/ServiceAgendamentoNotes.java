package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelAgendamentoNotes;
import reserva.notes.notes.model.ModelNotebooks;
import reserva.notes.notes.repo.RepoAgendamentoNotes;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAgendamentoNotes {
@Autowired
    private RepoAgendamentoNotes repoAgendamentoNotes;

    public ModelAgendamentoNotes salvarAgendamentoNotes(ModelAgendamentoNotes agendamentoNotes){
        return repoAgendamentoNotes.save(agendamentoNotes);

    }
    public List<ModelAgendamentoNotes> listarAgendamentoNotes(){
        return repoAgendamentoNotes.findAll();
    }

    public ModelAgendamentoNotes buscarAgendamentoNotesPorId(Long id) throws RegistroNaoEncontradoException{
        Optional<ModelAgendamentoNotes> opt = repoAgendamentoNotes.findById(id);
        if (opt.isPresent()){
            return opt.get();
        }else {
            throw new RegistroNaoEncontradoException("Agendamento notes com id: " + id + " não existe");
        }
    }

    public void apagarAgendamentoNotes(Long id) throws RegistroNaoEncontradoException{
        ModelAgendamentoNotes agendamentoNotes = buscarAgendamentoNotesPorId(id);
        repoAgendamentoNotes.delete(agendamentoNotes);
    }
}
