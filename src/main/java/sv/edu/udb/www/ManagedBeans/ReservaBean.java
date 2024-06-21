package sv.edu.udb.www.ManagedBeans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.bean.ViewScoped;
import sv.edu.udb.www.Models.FormaPagoModel;
import sv.edu.udb.www.Models.HabitacionModel;
import sv.edu.udb.www.Models.ReservaModel;
import sv.edu.udb.www.Models.UsuarioModel;
import sv.edu.udb.www.entities.FormaPagoEntity;
import sv.edu.udb.www.entities.HabitacionEntity;
import sv.edu.udb.www.entities.ReservaEntity;
import sv.edu.udb.www.entities.UsuarioEntity;

import java.util.List;
@ManagedBean
@RequestScoped
@ViewScoped
public class ReservaBean {

    ReservaModel modelReserva = new ReservaModel();
    HabitacionModel modelHabitacion = new HabitacionModel();
    UsuarioModel modelUsuario = new UsuarioModel();
    FormaPagoModel modelFormaPago = new FormaPagoModel();

    private List<ReservaEntity> reservas;
    private List<HabitacionEntity> habitaciones;
    private List<UsuarioEntity> usuarios;
    private List<FormaPagoEntity> formaPagos;
    private ReservaEntity reserva;
    private HabitacionEntity habitacion;
    private UsuarioEntity usuario;
    private FormaPagoEntity formapago;


    public ReservaBean() {
        reserva=new ReservaEntity();
        habitacion = new HabitacionEntity();
        usuario = new UsuarioEntity();
        formapago = new FormaPagoEntity();
    }

    public ReservaModel getModelReserva() {
        return modelReserva;
    }

    public void setModelReserva(ReservaModel modelReserva) {
        this.modelReserva = modelReserva;
    }

    public HabitacionModel getModelHabitacion() {
        return modelHabitacion;
    }

    public void setModelHabitacion(HabitacionModel modelHabitacion) {
        this.modelHabitacion = modelHabitacion;
    }

    public UsuarioModel getModelUsuario() {
        return modelUsuario;
    }

    public void setModelUsuario(UsuarioModel modelUsuario) {
        this.modelUsuario = modelUsuario;
    }

    public FormaPagoModel getModelFormaPago() {
        return modelFormaPago;
    }

    public void setModelFormaPago(FormaPagoModel modelFormaPago) {
        this.modelFormaPago = modelFormaPago;
    }

    public List<ReservaEntity> getReservas() {
        return modelReserva.listarReserva();
    }

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }

    public List<HabitacionEntity> getHabitaciones() {
        return modelHabitacion.listarhabitaciones();
    }

    public void setHabitaciones(List<HabitacionEntity> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<UsuarioEntity> getUsuarios() {
        return modelUsuario.listarusuarios();
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

    public List<FormaPagoEntity> getFormaPagos() {
        return modelFormaPago.listarPagos();
    }

    public void setFormaPagos(List<FormaPagoEntity> formaPagos) {
        this.formaPagos = formaPagos;
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public HabitacionEntity getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionEntity habitacion) {
        this.habitacion = habitacion;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public FormaPagoEntity getFormapago() {
        return formapago;
    }

    public void setFormapago(FormaPagoEntity formapago) {
        this.formapago = formapago;
    }

    public void agregarReserva() {

        this.reserva.setIdCliente(modelUsuario.obtenerUsuarios(this.usuario.getId()));
       this.reserva.setIdHabitacion(modelHabitacion.obtenerhabitacion(this.habitacion.getId()));
        this.reserva.setIdFormaPago(modelFormaPago.obtenerPagos(this.formapago.getId()));
        modelReserva.insertarReserva(this.reserva);

    }

    public void editarReserva() {
        this.reserva.setIdCliente(modelUsuario.obtenerUsuarios(this.usuario.getId()));
        this.reserva.setIdHabitacion(modelHabitacion.obtenerhabitacion(this.habitacion.getId()));
        this.reserva.setIdFormaPago(modelFormaPago.obtenerPagos(this.formapago.getId()));
        modelReserva.modificarReserva(this.reserva);
        this.reserva = null;
    }

    public void eliminarReserva(int idreserva) {
        modelReserva.eliminarReserva(idreserva);
        this.reservas = modelReserva.listarReserva();


    }

    public void cargarReserva() {
        reservas = modelReserva.listarReserva();
    }

}
