package reserva.notes.notes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Agendamento_Note")
public class ModelAgendamentoNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_agendamento;
    private Long id_notebook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(Long id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public Long getId_notebook() {
        return id_notebook;
    }

    public void setId_notebook(Long id_notebook) {
        this.id_notebook = id_notebook;
    }
}
