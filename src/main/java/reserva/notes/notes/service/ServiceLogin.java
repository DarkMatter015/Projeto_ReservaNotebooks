package reserva.notes.notes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelLogin;
import reserva.notes.notes.repo.RepoLogin;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLogin {
    @Autowired
    private RepoLogin repoLogin;

    public ModelLogin salvarLogin(ModelLogin login) {
        return repoLogin.save(login);
    }

    public List<ModelLogin> listarLogin() {
        return repoLogin.findAll();
    }

    public ModelLogin buscarLoginPorId(Long id) throws RegistroNaoEncontradoException {
        Optional<ModelLogin> opt = repoLogin.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RegistroNaoEncontradoException("Usuário com id : " + id + " não existe");
        }
    }

    public void apagarLogin(Long id) throws RegistroNaoEncontradoException {
        ModelLogin login  = buscarLoginPorId(id);
        repoLogin.delete(login);
    }
}
