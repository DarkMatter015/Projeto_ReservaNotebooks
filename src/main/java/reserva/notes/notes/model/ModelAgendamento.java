package reserva.notes.notes.model;

import jakarta.persistence.*;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "agendamento")
public class ModelAgendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private ModelLogin usuario;

    private Date data_agendada;

    private Time hora_devolvida;

    private Time hora_retirada;

    private int turno;

    private Timestamp datahora_criacao;

    private int status;

    public Time getHora_retirada() {
        return hora_retirada;
    }

    public void setHora_retirada(Time hora_retirada) {
        this.hora_retirada = hora_retirada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModelLogin getUsuario_id() {
        return usuario;
    }

    public void setUsuario_id(ModelLogin usuario_id) {
        this.usuario = usuario_id;
    }

    public Date getData_agendada() {
        return data_agendada;
    }

    public void setData_agendada(Date data_agendada) {
        this.data_agendada = data_agendada;
    }

    public Time getHora_devolvida() {
        return hora_devolvida;
    }

    public void setHora_devolvida(Time hora_devolvida) {
        this.hora_devolvida = hora_devolvida;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Timestamp getDatahora_criacao() {
        return datahora_criacao;
    }

    public void setDatahora_criacao(Timestamp datahora_criacao) {
        this.datahora_criacao = datahora_criacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
