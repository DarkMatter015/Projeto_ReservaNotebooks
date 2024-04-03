package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import reserva.notes.notes.model.ModelAgendamento;

public interface RepoAgendamento extends JpaRepository<ModelAgendamento, Long> {
}
