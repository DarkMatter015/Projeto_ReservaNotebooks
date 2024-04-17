package reserva.notes.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reserva.notes.notes.model.ModelLogin;
@Repository
public interface RepoLogin extends JpaRepository<ModelLogin, Long> {
    @Query(value = "SELECT * FROM usuario WHERE matricula = :matricula AND senha = :senha LIMIT 1", nativeQuery = true)
    ModelLogin validaLogin(@Param("matricula") int matricula, @Param("senha") String senha);
}
