package reserva.notes.notes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.notes.notes.model.ModelLogin;
import reserva.notes.notes.repo.RepoLogin;

import java.util.List;

@Service
public class ServiceLogin {
    @Autowired
    private RepoLogin repoLogin;
    public ModelLogin salvarLogin(ModelLogin login){
        return repoLogin.save(login);
    }
    public List<ModelLogin> listarLogin(){
        return repoLogin.findAll();
    }

    public void apagarLogin(ModelLogin login){
        repoLogin.delete(login);
    }
}
