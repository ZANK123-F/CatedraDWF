package sv.edu.udb.www.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "reserva")
@NamedQueries(
        {@NamedQuery(name="ReservaEntity.findAll",query = "SELECT e FROM ReservaEntity  e"),
                @NamedQuery(name = "ReservaEntity.findById", query = "SELECT e FROM ReservaEntity  e WHERE e.id = :id")})

public class ReservaEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_habitacion", nullable = false)
    private HabitacionEntity idHabitacionEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private UsuarioEntity idCliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_forma_pago", nullable = false)
    private FormaPagoEntity idFormaPagoEntity;

    @NotNull

    @Column(name = "hora_entrada")
    private Instant horaEntrada;


    @Column(name = "hora_salida")
    private Instant horaSalida;

    @Column(name = "cantidad_personas", nullable = false)
    private Integer cantidadPersonas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HabitacionEntity getIdHabitacion() {
        return idHabitacionEntity;
    }

    public void setIdHabitacion(HabitacionEntity idHabitacionEntity) {
        this.idHabitacionEntity = idHabitacionEntity;
    }

    public UsuarioEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UsuarioEntity idCliente) {
        this.idCliente = idCliente;
    }

    public FormaPagoEntity getIdFormaPago() {
        return idFormaPagoEntity;
    }

    public void setIdFormaPago(FormaPagoEntity idFormaPagoEntity) {
        this.idFormaPagoEntity = idFormaPagoEntity;
    }

    public Instant getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Instant horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Instant getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Instant horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

}