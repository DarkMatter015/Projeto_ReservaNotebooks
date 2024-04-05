package reserva.notes.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelCategoria;
import reserva.notes.notes.repo.RepoCategoria;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoria {

    @Autowired
    private RepoCategoria repoCategoria;

    public ModelCategoria salvarCategoria(ModelCategoria categoria){
        return repoCategoria.save(categoria);
    }

    public List<ModelCategoria> listarCategorias(){
        return repoCategoria.findAll();
    }

    public ModelCategoria buscarCategoriaPorId(Long id)throws RegistroNaoEncontradoException {
        Optional<ModelCategoria> opt = repoCategoria.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RegistroNaoEncontradoException("Categoria com id : " + id + " não existe");
        }
    }

    public void apagarCategoria(Long id) throws RegistroNaoEncontradoException {
        ModelCategoria categoria = buscarCategoriaPorId(id);
        repoCategoria.delete(categoria);
    }



}
