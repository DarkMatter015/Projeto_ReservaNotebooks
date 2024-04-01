package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelNotebooks;
import reserva.notes.notes.repo.RepoNotebooks;

import java.util.List;
import java.util.Optional;

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

    public ModelNotebooks buscarNotebookPorId(Long id)throws RegistroNaoEncontradoException {
        Optional<ModelNotebooks> opt = repoNotebooks.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RegistroNaoEncontradoException("Notebook com id : " + id + " não existe");
        }
    }

    public void apagarNotebook(Long id) throws RegistroNaoEncontradoException {
        ModelNotebooks notebook = buscarNotebookPorId(id);
        repoNotebooks.delete(notebook);
    }

}
