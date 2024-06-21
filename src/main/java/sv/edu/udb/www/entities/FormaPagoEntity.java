package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "forma_pago")
@NamedQueries(
        {@NamedQuery(name="FormaPagoEntity.findAll",query = "SELECT e FROM FormaPagoEntity  e"),
                @NamedQuery(name = "FormaPagoEntity.findById", query = "SELECT e FROM FormaPagoEntity  e WHERE e.id = :id")})

public class FormaPagoEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}