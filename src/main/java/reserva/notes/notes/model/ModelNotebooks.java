package reserva.notes.notes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notebook")
public class ModelNotebooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numero;

    private int patrimonio;

    private Long categoria_id;

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

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }
}
