package reserva.notes.notes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Agendamento_Note")
public class ModelAgendamentoNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int id_agendamento;
    private int id_notebook;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public int getId_notebook() {
        return id_notebook;
    }

    public void setId_notebook(int id_notebook) {
        this.id_notebook = id_notebook;
    }
}
