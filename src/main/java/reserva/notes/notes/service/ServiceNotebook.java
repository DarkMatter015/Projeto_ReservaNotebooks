package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelNotebook;
<<<<<<< HEAD
import reserva.notes.notes.repo.RepoNotebook;
=======
import reserva.notes.notes.repo.RepoNotebooks;
>>>>>>> main

import java.util.List;
import java.util.Optional;

@Service
public class ServiceNotebook {
    @Autowired
<<<<<<< HEAD
    private RepoNotebook repoNotebook;

    public ModelNotebook salvarNotebook(ModelNotebook notebook){
        return repoNotebook.save(notebook);
    }

    public List<ModelNotebook> listarNotebooks(){
        return repoNotebook.findAll();
    }

    public ModelNotebook buscarNotebookPorId(Long id)throws RegistroNaoEncontradoException {
        Optional<ModelNotebook> opt = repoNotebook.findById(id);
=======
    private RepoNotebooks repoNotebooks;

    public ModelNotebook salvarNotebook(ModelNotebook notebook){
        return repoNotebooks.save(notebook);
    }

    public List<ModelNotebook> listarNotebooks(){
        return repoNotebooks.findAll();
    }

    public ModelNotebook buscarNotebookPorId(Long id)throws RegistroNaoEncontradoException {
        Optional<ModelNotebook> opt = repoNotebooks.findById(id);
>>>>>>> main
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RegistroNaoEncontradoException("Notebook com id : " + id + " não existe");
        }
    }

    public void apagarNotebook(Long id) throws RegistroNaoEncontradoException {
        ModelNotebook notebook = buscarNotebookPorId(id);
<<<<<<< HEAD
        repoNotebook.delete(notebook);
=======
        repoNotebooks.delete(notebook);
>>>>>>> main
    }

}
