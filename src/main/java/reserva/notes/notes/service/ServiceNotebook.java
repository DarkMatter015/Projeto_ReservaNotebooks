package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelNotebook;
import reserva.notes.notes.repo.RepoNotebook;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceNotebook {
    @Autowired
    private RepoNotebook repoNotebook;

    public ModelNotebook salvarNotebook(ModelNotebook notebook){
        return repoNotebook.save(notebook);
    }

    public List<ModelNotebook> listarNotebooks(){
        return repoNotebook.findAll();
    }

    public ModelNotebook buscarNotebookPorId(Long id)throws RegistroNaoEncontradoException {
        Optional<ModelNotebook> opt = repoNotebook.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RegistroNaoEncontradoException("Notebook com id : " + id + " não existe");
        }
    }

    public void apagarNotebook(Long id) throws RegistroNaoEncontradoException {
        ModelNotebook notebook = buscarNotebookPorId(id);
        repoNotebook.delete(notebook);
    }

}
