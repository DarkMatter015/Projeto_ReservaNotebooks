package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.model.ModelCategoria;
import reserva.notes.notes.repo.RepoCategoria;

import java.util.List;

@Service
public class ServiceCategoria {

    @Autowired
    private RepoCategoria repoCategoria;

    public ModelCategoria salvarCategoria(ModelCategoria categoria){
        return repoCategoria.save(categoria);
    }

    public List<ModelCategoria> listarCategoria(){
        return repoCategoria.findAll();
    }

    public void apagarCategoria(ModelCategoria categoria){
        repoCategoria.delete(categoria);
    }

}
