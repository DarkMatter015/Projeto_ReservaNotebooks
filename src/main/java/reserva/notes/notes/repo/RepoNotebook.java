package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reserva.notes.notes.model.ModelNotebook;

@Repository
public interface RepoNotebook extends JpaRepository<ModelNotebook, Long> {
}
