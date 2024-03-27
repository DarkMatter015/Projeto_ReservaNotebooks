package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reserva.notes.notes.model.ModelAgendamentoNotes;

@Repository
public interface RepoAgendamentoNotes extends JpaRepository <ModelAgendamentoNotes, Long> {

}