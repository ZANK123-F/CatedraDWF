package sv.edu.udb.www.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuario")
@NamedQueries(
        {@NamedQuery(name="UsuarioEntity.findAll",query = "SELECT e FROM UsuarioEntity  e"),
                @NamedQuery(name = "UsuarioEntity.findById", query = "SELECT e FROM UsuarioEntity  e WHERE e.id = :id")})

public class UsuarioEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity idRolEntity;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoEntity idTipoDocumentoEntity;

    @Column(name = "numero_documento", length = 50)
    private String numeroDocumento;

    @Column(name = "direccion", length = 500)
    private String direccion;

    @Pattern(regexp = "[6][0-9]{8}")
    @Column(name = "telefono", length = 15)
    private String telefono;

    @Email
    @NotNull
    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "contrasenia", length = 100)
    private String contrasenia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo_trabajador")
    private CargoTrabajadorEntity idCargoTrabajadorEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RolEntity getIdRol() {
        return idRolEntity;
    }

    public void setIdRol(RolEntity idRolEntity) {
        this.idRolEntity = idRolEntity;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public TipoDocumentoEntity getIdTipoDocumento() {
        return idTipoDocumentoEntity;
    }

    public void setIdTipoDocumento(TipoDocumentoEntity idTipoDocumentoEntity) {
        this.idTipoDocumentoEntity = idTipoDocumentoEntity;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public CargoTrabajadorEntity getIdCargoTrabajador() {
        return idCargoTrabajadorEntity;
    }

    public void setIdCargoTrabajador(CargoTrabajadorEntity idCargoTrabajadorEntity) {
        this.idCargoTrabajadorEntity = idCargoTrabajadorEntity;
    }

}