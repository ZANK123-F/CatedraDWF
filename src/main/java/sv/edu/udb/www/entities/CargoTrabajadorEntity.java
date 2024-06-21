package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo_trabajador")
@NamedQueries(
{@NamedQuery(name="CargoTrabajadorEntity.findAll",query = "SELECT e FROM CargoTrabajadorEntity  e"),
    @NamedQuery(name = "CargoTrabajadorEntity.findById", query = "SELECT e FROM CargoTrabajadorEntity  e WHERE e.id = :id")})

public class CargoTrabajadorEntity {
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