package reserva.notes.notes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notebook")
public class ModelNotebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private int patrimonio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private ModelCategoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public ModelCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ModelCategoria categoria) {
        this.categoria = categoria;
    }
}
