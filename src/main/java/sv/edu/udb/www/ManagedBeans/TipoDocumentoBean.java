package sv.edu.udb.www.ManagedBeans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import sv.edu.udb.www.Models.TipoDocumentoModel;
import sv.edu.udb.www.entities.TipoDocumentoEntity;

import java.util.List;
@ManagedBean
@RequestScoped
public class TipoDocumentoBean {

    TipoDocumentoModel modelTipoDocumento = new TipoDocumentoModel();
    private List<TipoDocumentoEntity> TipoDocumento;
    private TipoDocumentoEntity tipoDocumento;

    public TipoDocumentoModel getModelTipoDocumento() {
        return modelTipoDocumento;
    }

    public void setModelTipoDocumento(TipoDocumentoModel modelTipoDocumento) {
        this.modelTipoDocumento = modelTipoDocumento;
    }

    public List<TipoDocumentoEntity> getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setTipoDocumento(List<TipoDocumentoEntity> tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    public void agregarTipoDocumento() {
        modelTipoDocumento.insertarTipodocumento(tipoDocumento);
    }

    public void editarTipoDocumento() {
        modelTipoDocumento.modificartipodocumento(tipoDocumento);
    }

    public void eliminarTipoDocumento(int idtipodocumento) {
        modelTipoDocumento.eliminartipodocumento(idtipodocumento);
        TipoDocumento = modelTipoDocumento.listarDocumentos();
    }

    public void cargarTipoDocumento() {
        TipoDocumento = modelTipoDocumento.listarDocumentos();
    }

}
