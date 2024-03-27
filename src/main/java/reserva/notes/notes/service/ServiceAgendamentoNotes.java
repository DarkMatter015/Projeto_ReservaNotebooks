package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.model.ModelAgendamentoNotes;
import reserva.notes.notes.model.ModelNotebooks;
import reserva.notes.notes.repo.RepoAgendamentoNotes;

import java.util.List;

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
    public void apagarAgendamentoNotes(ModelAgendamentoNotes agendamentoNotes){
        repoAgendamentoNotes.delete(agendamentoNotes);
    }
}
