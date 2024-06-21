package sv.edu.udb.www.ManagedBeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.persistence.Entity;
import sv.edu.udb.www.Models.HabitacionModel;
import sv.edu.udb.www.Models.TipoHabitacionModel;
import sv.edu.udb.www.entities.HabitacionEntity;
import sv.edu.udb.www.entities.TipoHabitacionEntity;

import java.util.List;

@ManagedBean
@ViewScoped

public class HabitacionBean {

    HabitacionModel modelHabitacion = new HabitacionModel();
    TipoHabitacionModel modelTipodehabitacion = new TipoHabitacionModel();
    private List<HabitacionEntity> habitaciones;
    private List<TipoHabitacionEntity> tipoHabitaciones;
    private HabitacionEntity habitacion;
    private TipoHabitacionEntity tipoHabitacion;

    public HabitacionBean() {
        habitacion = new HabitacionEntity();
        tipoHabitacion = new TipoHabitacionEntity();
    }

    public HabitacionModel getModelHabitacion() {
        return modelHabitacion;
    }

    public void setModelHabitacion(HabitacionModel modelHabitacion) {
        this.modelHabitacion = modelHabitacion;
    }

    public TipoHabitacionModel getModelTipodehabitacion() {
        return modelTipodehabitacion;
    }

    public void setModelTipodehabitacion(TipoHabitacionModel modelTipodehabitacion) {
        this.modelTipodehabitacion = modelTipodehabitacion;
    }

    public List<HabitacionEntity> getHabitaciones() {
        return modelHabitacion.listarhabitaciones();
    }

    public void setHabitaciones(List<HabitacionEntity> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<TipoHabitacionEntity> getTipoHabitaciones() {
        return modelTipodehabitacion.listarhabitacionestipo();
    }

    public void setTipoHabitaciones(List<TipoHabitacionEntity> tipoHabitaciones) {
        this.tipoHabitaciones = tipoHabitaciones;
    }

    public HabitacionEntity getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionEntity habitacion) {
        this.habitacion = habitacion;
    }

    public TipoHabitacionEntity getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacionEntity tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void agregarHabitacion() {
        this.habitacion.setIdTipoHabitacion(modelTipodehabitacion.obtenerhabitacion(this.tipoHabitacion.getId()));
        modelHabitacion.insertarhabitacion(this.habitacion);
    }

    public void editarHabitacion() {
        this.habitacion.setIdTipoHabitacion(modelTipodehabitacion.obtenerhabitacion(this.tipoHabitacion.getId()));
        modelHabitacion.modificarHabitacion(this.habitacion);
        this.habitacion = null;

    }

    public void eliminarHabitacion(int idhabitacion) {
        modelHabitacion.eliminarHabitacion(idhabitacion);
        this.habitaciones = modelHabitacion.listarhabitaciones();

    }

    public void cargarHabitacion() {
      habitaciones = modelHabitacion.listarhabitaciones();

    }
}
