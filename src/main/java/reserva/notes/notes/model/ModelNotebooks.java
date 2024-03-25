package reserva.notes.notes.model;

import jakarta.persistence.*;

@Entity
public class ModelNotebooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numero;

    private int patrimonio;

    @ManyToOne
    private ModelCategoria categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
