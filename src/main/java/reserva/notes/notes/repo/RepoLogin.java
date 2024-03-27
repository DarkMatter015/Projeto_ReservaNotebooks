package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reserva.notes.notes.model.ModelLogin;
@Repository

public interface RepoLogin extends JpaRepository<ModelLogin, Long> {
}
