package reserva.notes.notes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "agendamento_note")
public class ModelAgendamentoNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long agendamento_id;
    private Long notebook_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgendamento_id() {
        return agendamento_id;
    }

    public void setAgendamento_id(Long agendamento_id) {
        this.agendamento_id = agendamento_id;
    }

    public Long getNotebook_id() {
        return notebook_id;
    }

    public void setNotebook_id(Long notebook_id) {
        this.notebook_id = notebook_id;
    }
}
