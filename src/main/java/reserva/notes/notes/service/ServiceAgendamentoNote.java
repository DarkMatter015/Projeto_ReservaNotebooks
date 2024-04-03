package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelAgendamentoNote;
import reserva.notes.notes.repo.RepoAgendamentoNotes;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAgendamentoNote {
@Autowired
    private RepoAgendamentoNotes repoAgendamentoNotes;

    public ModelAgendamentoNote salvarAgendamentoNotes(ModelAgendamentoNote agendamentoNotes){
        return repoAgendamentoNotes.save(agendamentoNotes);

    }
    public List<ModelAgendamentoNote> listarAgendamentoNotes(){
        return repoAgendamentoNotes.findAll();
    }

    public ModelAgendamentoNote buscarAgendamentoNotesPorId(Long id) throws RegistroNaoEncontradoException{
        Optional<ModelAgendamentoNote> opt = repoAgendamentoNotes.findById(id);
        if (opt.isPresent()){
            return opt.get();
        }else {
            throw new RegistroNaoEncontradoException("Agendamento notes com id: " + id + " não existe");
        }
    }

    public void apagarAgendamentoNotes(Long id) throws RegistroNaoEncontradoException{
        ModelAgendamentoNote agendamentoNotes = buscarAgendamentoNotesPorId(id);
        repoAgendamentoNotes.delete(agendamentoNotes);
    }
}
