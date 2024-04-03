package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reserva.notes.notes.model.ModelAgendamentoNote;

@Repository
public interface RepoAgendamentoNote extends JpaRepository <ModelAgendamentoNote, Long> {

}
