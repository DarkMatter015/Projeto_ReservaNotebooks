package reserva.notes.notes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notebooks")
public class ModelNotebooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numero;

    private int patrimonio;

    private Long id_categoria;

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

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }
}
