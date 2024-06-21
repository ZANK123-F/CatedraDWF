package sv.edu.udb.www.ManagedBeans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import sv.edu.udb.www.Models.RolModel;
import sv.edu.udb.www.entities.RolEntity;

import java.util.List;
@ManagedBean
@RequestScoped
public class RolBean {

    RolModel modelRol = new RolModel();
    private List<RolEntity> Rol;
    private RolEntity rol;

    public RolModel getModelRol() {
        return modelRol;
    }

    public void setModelRol(RolModel modelRol) {
        this.modelRol = modelRol;
    }

    public List<RolEntity> getRol() {
        return Rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public void setRol(List<RolEntity> rol) {
        Rol = rol;
    }


    public void agregarRol() {
        modelRol.insertarRol(rol);
    }

    public void editarRol() {
        modelRol.modificarRol(rol);
    }

    public void eliminarRol(int idrol) {
        modelRol.eliminarRol(idrol);
        Rol = modelRol.listarRoles();
    }

    public void cargarRol() {
        Rol = modelRol.listarRoles();
    }

}
