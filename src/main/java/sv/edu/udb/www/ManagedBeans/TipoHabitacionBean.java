package sv.edu.udb.www.ManagedBeans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import sv.edu.udb.www.Models.TipoHabitacionModel;
import sv.edu.udb.www.entities.TipoHabitacionEntity;

import java.util.List;
@ManagedBean
@RequestScoped
public class TipoHabitacionBean {
    TipoHabitacionModel modeTipoHabitacion = new TipoHabitacionModel();
    private List<TipoHabitacionEntity> TipoHabitacion;
    private TipoHabitacionEntity tipoHabitacion;

    public TipoHabitacionModel getModeTipoHabitacion() {
        return modeTipoHabitacion;
    }

    public void setModeTipoHabitacion(TipoHabitacionModel modeTipoHabitacion) {
        this.modeTipoHabitacion = modeTipoHabitacion;
    }

    public List<TipoHabitacionEntity> getTipoHabitacion() {
        return modeTipoHabitacion.listarhabitacionestipo();
    }

    public void setTipoHabitacion(TipoHabitacionEntity tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setTipoHabitacion(List<TipoHabitacionEntity> tipoHabitacion) {
        TipoHabitacion = tipoHabitacion;
    }
    public void agregarTipoHabitacion() {
        modeTipoHabitacion.insertarhabitacion(tipoHabitacion);
    }

    public void editarTipoHabitacion() {
        modeTipoHabitacion.modificarHabitacionTipo(tipoHabitacion);
    }

    public void eliminarTipoHabitacion(int idtipoHabitacion) {
        modeTipoHabitacion.eliminarHabitacionTipo(idtipoHabitacion);
        cargarTipoHabitacion();
    }

    public void cargarTipoHabitacion() {
        modeTipoHabitacion.listarhabitacionestipo();
    }

}
