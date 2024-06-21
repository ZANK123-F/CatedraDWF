package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_documento")
@NamedQueries(
        {@NamedQuery(name="TipoDocumentoEntity.findAll",query = "SELECT e FROM TipoDocumentoEntity  e"),
                @NamedQuery(name = "TipoDocumentoEntity.findById", query = "SELECT e FROM TipoDocumentoEntity  e WHERE e.id = :id")})

public class TipoDocumentoEntity {
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