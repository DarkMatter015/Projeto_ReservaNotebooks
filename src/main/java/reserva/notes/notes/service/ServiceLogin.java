package reserva.notes.notes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reserva.notes.notes.exception.RegistroNaoEncontradoException;
import reserva.notes.notes.model.ModelLogin;
import reserva.notes.notes.repo.RepoLogin;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLogin {
    @Autowired
    private static RepoLogin repoLogin;

    @Autowired
    private ServiceEnvioEmail envioEmail;

    public ServiceLogin(RepoLogin repoLogin){
        this.repoLogin = repoLogin;
    }

    public ModelLogin salvarLogin(ModelLogin login) {
        login.setSenha(ServiceGeradorSenha.gerarSenha(5, 3, 1));
        ModelLogin retorno = repoLogin.save(login);

        envioEmail.enviarEmail(login.getEmail(), "Conta usuario RESERVA NOTEBOOK", "Seu usuário é "
                + login.getMatricula() + " e sua senha é " + login.getSenha());

        return retorno;
    }

    public List<ModelLogin> listarLogin() {
        return repoLogin.findAll(Sort.by("id"));
    }

    public  static ModelLogin validaLogin(String matricula, String senha){
        return repoLogin.validaLogin(Integer.parseInt(matricula), senha);
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
