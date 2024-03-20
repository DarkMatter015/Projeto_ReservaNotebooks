package reserva.notes.notes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class ModelCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome da categoria não pode ser em branco!")
    private String nome;

    private int prioridade;

    private int quantidade;

    @OneToMany(mappedBy = "categoria")
    private List<ModelNotebooks> notebooks;

    public List<ModelNotebooks> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(List<ModelNotebooks> notebooks) {
        this.notebooks = notebooks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
