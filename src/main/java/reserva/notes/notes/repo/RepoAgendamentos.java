package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import reserva.notes.notes.model.ModelAgendamentos;

public interface RepoAgendamentos extends JpaRepository<ModelAgendamentos, Long> {
}
