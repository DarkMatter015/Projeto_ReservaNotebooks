package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.model.ModelAgendamentos;
import reserva.notes.notes.repo.RepoAgendamentos;
import java.util.List;
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
    public void apagarAgendamentos(ModelAgendamentos agendamentos){
        repoAgendamentos.delete(agendamentos);
    }
}
