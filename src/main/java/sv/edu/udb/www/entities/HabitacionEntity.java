package sv.edu.udb.www.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "habitacion")
@NamedQueries(
        {@NamedQuery(name="HabitacionEntity.findAll",query = "SELECT e FROM HabitacionEntity  e"),
                @NamedQuery(name = "HabitacionEntity.findById", query = "SELECT e FROM HabitacionEntity  e WHERE e.id = :id")})

public class HabitacionEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_habitacion")
    private TipoHabitacionEntity idTipoHabitacionEntity;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "piso", nullable = false)
    private Integer piso;

    @Size(min = 1, max = 50)
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "imagen", length = 1000)
    private String imagen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoHabitacionEntity getIdTipoHabitacion() {
        return idTipoHabitacionEntity;
    }

    public void setIdTipoHabitacion(TipoHabitacionEntity idTipoHabitacionEntity) {
        this.idTipoHabitacionEntity = idTipoHabitacionEntity;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}