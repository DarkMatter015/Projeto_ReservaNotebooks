package reserva.notes.notes.model;

import jakarta.persistence.*;

@Entity
public class ModelReservaNots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ModelLogin usuario;

    private String data_agendada;

    private String hora_devolvida ;


    private int turno;

    private String datahora_criacao;

    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModelLogin getUsuario() {
        return usuario;
    }

    public void setUsuario(ModelLogin usuario) {
        this.usuario = usuario;
    }

    public String getData_agendada() {
        return data_agendada;
    }

    public void setData_agendada(String data_agendada) {
        this.data_agendada = data_agendada;
    }

    public String getHora_devolvida() {
        return hora_devolvida;
    }

    public void setHora_devolvida(String hora_devolvida) {
        this.hora_devolvida = hora_devolvida;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getDatahora_criacao() {
        return datahora_criacao;
    }

    public void setDatahora_criacao(String datahora_criacao) {
        this.datahora_criacao = datahora_criacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
