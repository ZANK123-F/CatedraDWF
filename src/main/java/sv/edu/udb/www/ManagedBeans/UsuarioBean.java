package sv.edu.udb.www.ManagedBeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.bean.ViewScoped;
import sv.edu.udb.www.Models.CargoTrabajadorModel;
import sv.edu.udb.www.Models.RolModel;
import sv.edu.udb.www.Models.TipoDocumentoModel;
import sv.edu.udb.www.Models.UsuarioModel;
import sv.edu.udb.www.entities.CargoTrabajadorEntity;
import sv.edu.udb.www.entities.RolEntity;
import sv.edu.udb.www.entities.TipoDocumentoEntity;
import sv.edu.udb.www.entities.UsuarioEntity;

import java.util.List;

@ManagedBean
@SessionScoped
@ViewScoped
public class UsuarioBean {

    UsuarioModel modelUsuario = new UsuarioModel();
    RolModel modelRol = new RolModel();
    TipoDocumentoModel modelDocumento = new TipoDocumentoModel();
    CargoTrabajadorModel modelCargoTrabajador = new CargoTrabajadorModel();

    private List<UsuarioEntity> usuarios;
    private List<RolEntity> roles;
    private List<TipoDocumentoEntity> tipoDocumentos;
    private List<CargoTrabajadorEntity> cargoTrabajadores;
    private UsuarioEntity usuario ;
    private RolEntity rol ;
    private TipoDocumentoEntity tipoDocumento ;
    private CargoTrabajadorEntity cargoTrabajador ;

    public UsuarioBean() {
        usuario = new UsuarioEntity();
        rol = new RolEntity();
        tipoDocumento = new TipoDocumentoEntity();
        cargoTrabajador = new CargoTrabajadorEntity();
    }

    public UsuarioModel getModelUsuario() {
        return modelUsuario;
    }

    public void setModelUsuario(UsuarioModel modelUsuario) {
        this.modelUsuario = modelUsuario;
    }

    public RolModel getModelRol() {
        return modelRol;
    }

    public void setModelRol(RolModel modelRol) {
        this.modelRol = modelRol;
    }

    public List<UsuarioEntity> getUsuarios() {
        return modelUsuario.listarusuarios();

    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

    public List<RolEntity> getRoles() {
        return modelRol.listarRoles();
    }

    public void setRoles(List<RolEntity> roles) {
        this.roles = roles;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public TipoDocumentoModel getModelDocumento() {
        return modelDocumento;
    }

    public void setModelDocumento(TipoDocumentoModel modelDocumento) {
        this.modelDocumento = modelDocumento;
    }

    public CargoTrabajadorModel getModelCargoTrabajador() {
        return modelCargoTrabajador;
    }

    public void setModelCargoTrabajador(CargoTrabajadorModel modelCargoTrabajador) {
        this.modelCargoTrabajador = modelCargoTrabajador;
    }

    public List<TipoDocumentoEntity> getTipoDocumentos() {
        return modelDocumento.listarDocumentos();
    }

    public void setTipoDocumentos(List<TipoDocumentoEntity> tipoDocumentos) {
        this.tipoDocumentos = tipoDocumentos;
    }

    public List<CargoTrabajadorEntity> getCargoTrabajadores() {
        return modelCargoTrabajador.listarcargoTrabajador();
    }

    public void setCargoTrabajadores(List<CargoTrabajadorEntity> cargoTrabajadores) {
        this.cargoTrabajadores = cargoTrabajadores;
    }

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public CargoTrabajadorEntity getCargoTrabajador() {
        return cargoTrabajador;
    }

    public void setCargoTrabajador(CargoTrabajadorEntity cargoTrabajador) {
        this.cargoTrabajador = cargoTrabajador;
    }
    public CargoTrabajadorEntity getCargoTrabajadorE(){
        return cargoTrabajador;
    }

    public void agregarUsuario() {




        this.usuario.setIdRol(modelRol.obtenerRoles(this.rol.getId()));
        this.usuario.setIdTipoDocumento(modelDocumento.obtenerDocumento(this.tipoDocumento.getId()));
        this.usuario.setIdCargoTrabajador(modelCargoTrabajador.obtenercargoTrabajador(this.cargoTrabajador.getId()));
        modelUsuario.insertarUsuarios(this.usuario);

    }

    public void editarUsuario() {
        this.usuario.setIdRol(modelRol.obtenerRoles(this.rol.getId()));
        this.usuario.setIdTipoDocumento(modelDocumento.obtenerDocumento(this.tipoDocumento.getId()));
        this.usuario.setIdCargoTrabajador(modelCargoTrabajador.obtenercargoTrabajador(this.cargoTrabajador.getId()));
        modelUsuario.modificarUsuarios(this.usuario);
        this.usuario = null;
    }

    public void eliminarUsuario(int idusuario) {
        modelUsuario.eliminarUsuarios(idusuario);
        this.usuarios = modelUsuario.listarusuarios();
    }

    public void cargarUsuario() {
        usuarios = modelUsuario.listarusuarios();
    }
}
