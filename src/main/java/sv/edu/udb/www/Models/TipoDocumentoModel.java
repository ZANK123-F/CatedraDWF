package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import sv.edu.udb.www.entities.TipoDocumentoEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class TipoDocumentoModel {
    public List<TipoDocumentoEntity> listarDocumentos(){
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("TipoDocumentoEntity.findAll");
            List<TipoDocumentoEntity> lista = consulta.getResultList();
            return lista;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }

    public TipoDocumentoEntity obtenerDocumento(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TipoDocumentoEntity tipodocumento = em.find(TipoDocumentoEntity.class, id);
            return tipodocumento;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }

    public int insertarTipodocumento(TipoDocumentoEntity tipoDocumento){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(tipoDocumento);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificartipodocumento(TipoDocumentoEntity tipoDocumento){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(tipoDocumento);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminartipodocumento(int id){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            TipoDocumentoEntity tipoDocumento = em.find(TipoDocumentoEntity.class, id);
            if(tipoDocumento !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(tipoDocumento);
                tran.commit();
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        }catch(Exception e){
            em.close();
            return 0;
        }

    }
}
