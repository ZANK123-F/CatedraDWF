package sv.edu.udb.www.ManagedBeans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import sv.edu.udb.www.Models.FormaPagoModel;
import sv.edu.udb.www.entities.FormaPagoEntity;

import java.util.List;
@ManagedBean
@RequestScoped
public class FormaPagoBean {

    FormaPagoModel modelFormaPago = new FormaPagoModel();
    private List<FormaPagoEntity> Formapago;
    private FormaPagoEntity formaPago;

    public FormaPagoBean() {

    }

    public FormaPagoModel getModelFormaPago() {
        return modelFormaPago;
    }

    public void setModelFormaPago(FormaPagoModel modelFormaPago) {
        this.modelFormaPago = modelFormaPago;
    }

    public List<FormaPagoEntity> getFormapago() {
        return Formapago;
    }

    public void setFormapago(List<FormaPagoEntity> formapago) {
        Formapago = formapago;
    }

    public FormaPagoEntity getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagoEntity formaPago) {
        this.formaPago = formaPago;
    }
    public void agregarFormaPago() {
        modelFormaPago.insertarPago(formaPago);
    }

    public void editarFormaPagp() {
        modelFormaPago.modificarPago(formaPago);
    }

    public void eliminarFormaPago(int idformapago) {
        modelFormaPago.eliminarPago(idformapago);
        Formapago = modelFormaPago.listarPagos();
    }

    public void cargarRol() {
        Formapago = modelFormaPago.listarPagos();
    }
}
