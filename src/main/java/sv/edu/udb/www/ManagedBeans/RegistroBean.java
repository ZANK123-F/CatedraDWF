package sv.edu.udb.www.ManagedBeans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.www.Models.RegistroModel;
import sv.edu.udb.www.entities.TipoDocumentoEntity;
import sv.edu.udb.www.entities.UsuarioEntity;

import java.util.List;

@ManagedBean
@SessionScoped
public class RegistroBean {
    private UsuarioEntity usuario = new UsuarioEntity();
    private RegistroModel registroModel = new RegistroModel();
    private List<TipoDocumentoEntity> tipoDocumentos;
    private List<UsuarioEntity> usuarios;


    public RegistroModel getRegistroModel() {
        return registroModel;
    }

    public void setRegistroModel(RegistroModel registroModel) {
        this.registroModel = registroModel;
    }

    public List<TipoDocumentoEntity> getUsuarios() {
        return tipoDocumentos;
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String registrarUsuario() {
        // Asignar automáticamente el rol de cliente (id = 3)
        usuario.setIdRol(registroModel.obtenerRolCliente());

        // Llamar al método del modelo para insertar el usuario
        int resultado = registroModel.insertarUsuario(usuario);

        // Redirigir a la página de inicio de sesión si el registro fue exitoso y el rol es cliente
        if (resultado == 1 && usuario.getIdRol().getId() == 3) {
            return "login.xhtml?faces-redirect=true";
        } else {
            // Manejar error de registro o rol incorrecto
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar el usuario o el rol no es cliente."));
            return "registro.xhtml";
        }
    }
}
