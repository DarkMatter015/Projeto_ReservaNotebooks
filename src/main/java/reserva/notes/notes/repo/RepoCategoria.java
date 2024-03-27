package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reserva.notes.notes.model.ModelCategoria;

@Repository
public interface RepoCategoria extends JpaRepository<ModelCategoria, Long> {
}
