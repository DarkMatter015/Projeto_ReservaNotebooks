package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.model.ModelNotebooks;
import reserva.notes.notes.repo.RepoNotebooks;

import java.util.List;

@Service
public class ServiceNotebooks {
    @Autowired
    private RepoNotebooks repoNotebooks;

    public ModelNotebooks salvarNotebook(ModelNotebooks notebook){
        return repoNotebooks.save(notebook);
    }

    public List<ModelNotebooks> listarNotebooks(){
        return repoNotebooks.findAll();
    }

    public void apagarNotebooks(ModelNotebooks notebook){
        repoNotebooks.delete(notebook);
    }


}
