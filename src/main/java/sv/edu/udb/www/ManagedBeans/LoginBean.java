package sv.edu.udb.www.ManagedBeans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.www.Models.UsuarioModel;
import sv.edu.udb.www.entities.RolEntity;
import sv.edu.udb.www.entities.UsuarioEntity;

@ManagedBean
@RequestScoped
public class LoginBean {
    private String correo;
    private String contrasenia;
    private UsuarioEntity usuario;
    private RolEntity rol;

    public String login() {
        UsuarioModel model = new UsuarioModel();
        usuario = model.verificarCredenciales(correo, contrasenia);
        if (usuario != null) {
            rol = usuario.getIdRol();
            switch (rol.getId()) {
                case 1:
                    return "/administrador/indexAdmin.xhtml?faces-redirect=true";
                case 2:
                    return "/trabajadores/indexEmpleados.xhtml?faces-redirect=true";
                case 3:
                    return "/cliente/indexCliente.xhtml?faces-redirect=true";
                default:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Rol no válido."));
                    return null;
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales inválidas."));
            return null;
        }
    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

}
