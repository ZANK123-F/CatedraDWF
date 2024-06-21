package sv.edu.udb.www.ManagedBeans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import sv.edu.udb.www.Models.CargoTrabajadorModel;
import sv.edu.udb.www.entities.CargoTrabajadorEntity;

import java.util.List;
@ManagedBean
@RequestScoped

public class CargoTrabajadorBean {

CargoTrabajadorModel modelCargoTrabajador = new CargoTrabajadorModel();
private List<CargoTrabajadorEntity> Trabajadores;
private CargoTrabajadorEntity trabajador;

    public CargoTrabajadorBean() {
        trabajador = new CargoTrabajadorEntity();
    }

    public CargoTrabajadorModel getModelCargoTrabajador() {
        return modelCargoTrabajador;
    }

    public void setModelCargoTrabajador(CargoTrabajadorModel modelCargoTrabajador) {
        this.modelCargoTrabajador = modelCargoTrabajador;
    }

    public List<CargoTrabajadorEntity> getTrabajadores() {
        return Trabajadores;
    }

    public void setTrabajadores(List<CargoTrabajadorEntity> trabajadores) {
        Trabajadores = trabajadores;
    }

    public CargoTrabajadorEntity getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(CargoTrabajadorEntity trabajador) {
        this.trabajador = trabajador;
    }
    public void agregarCargoTrabajador() {

        modelCargoTrabajador.insertarTrabajador(this.trabajador);
    }

    public void editarCargoTrabajador() {
        modelCargoTrabajador.modificarcargoTrabajador(this.trabajador);
    }

    public void eliminarCliente(int idcargotrabajador) {

        modelCargoTrabajador.eliminarcargoTrabajador(idcargotrabajador);
        this.Trabajadores = modelCargoTrabajador.listarcargoTrabajador();
    }

    public void cargarCargoTrabajador() {
        Trabajadores = modelCargoTrabajador.listarcargoTrabajador();
    }

}
