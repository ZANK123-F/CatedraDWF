package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tipo_habitacion")
@NamedQueries(
        {@NamedQuery(name="TipoHabitacionEntity.findAll",query = "SELECT e FROM TipoHabitacionEntity  e"),
                @NamedQuery(name = "TipoHabitacionEntity.findById", query = "SELECT e FROM TipoHabitacionEntity  e WHERE e.id = :id")})

public class TipoHabitacionEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 4)
    private BigDecimal precio;

    @Column(name = "maximo_invitados", nullable = false)
    private Integer maximoInvitados;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getMaximoInvitados() {
        return maximoInvitados;
    }

    public void setMaximoInvitados(Integer maximoInvitados) {
        this.maximoInvitados = maximoInvitados;
    }

}