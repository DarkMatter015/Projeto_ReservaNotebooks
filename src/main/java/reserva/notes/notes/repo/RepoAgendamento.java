package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reserva.notes.notes.model.ModelAgendamento;
import reserva.notes.notes.model.ModelLogin;

public interface RepoAgendamento extends JpaRepository<ModelAgendamento, Long> {
    @Query(value = "SELECT * FROM agendamento WHERE hora_retirada > :inicio AND hora_devolvida < :fim", nativeQuery = true)
    ModelAgendamento lista(@Param("inicio") String inicio, @Param("fim") String fim);
}
