package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelAgendamentoNote;
<<<<<<< HEAD
import reserva.notes.notes.repo.RepoAgendamentoNote;
=======
import reserva.notes.notes.repo.RepoAgendamentoNotes;
>>>>>>> main

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAgendamentoNote {
@Autowired
<<<<<<< HEAD
    private RepoAgendamentoNote repoAgendamentoNote;

    public ModelAgendamentoNote salvarAgendamentoNotes(ModelAgendamentoNote agendamentoNotes){
        return repoAgendamentoNote.save(agendamentoNotes);

    }
    public List<ModelAgendamentoNote> listarAgendamentoNotes(){
        return repoAgendamentoNote.findAll();
    }

    public ModelAgendamentoNote buscarAgendamentoNotesPorId(Long id) throws RegistroNaoEncontradoException{
        Optional<ModelAgendamentoNote> opt = repoAgendamentoNote.findById(id);
=======
    private RepoAgendamentoNotes repoAgendamentoNotes;

    public ModelAgendamentoNote salvarAgendamentoNotes(ModelAgendamentoNote agendamentoNotes){
        return repoAgendamentoNotes.save(agendamentoNotes);

    }
    public List<ModelAgendamentoNote> listarAgendamentoNotes(){
        return repoAgendamentoNotes.findAll();
    }

    public ModelAgendamentoNote buscarAgendamentoNotesPorId(Long id) throws RegistroNaoEncontradoException{
        Optional<ModelAgendamentoNote> opt = repoAgendamentoNotes.findById(id);
>>>>>>> main
        if (opt.isPresent()){
            return opt.get();
        }else {
            throw new RegistroNaoEncontradoException("Agendamento notes com id: " + id + " não existe");
        }
    }

    public void apagarAgendamentoNotes(Long id) throws RegistroNaoEncontradoException{
        ModelAgendamentoNote agendamentoNotes = buscarAgendamentoNotesPorId(id);
<<<<<<< HEAD
        repoAgendamentoNote.delete(agendamentoNotes);
=======
        repoAgendamentoNotes.delete(agendamentoNotes);
>>>>>>> main
    }
}
