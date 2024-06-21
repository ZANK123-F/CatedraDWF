package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.FormaPagoEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class FormaPagoModel {
    public List<FormaPagoEntity> listarPagos(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("FormaPagoEntity.findAll");
            List<FormaPagoEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public FormaPagoEntity obtenerPagos(int id){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            FormaPagoEntity consumo = em.find(FormaPagoEntity.class, id);
            em.close();
            return  consumo;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarPago(FormaPagoEntity pago){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(pago);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarPago(FormaPagoEntity pago){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(pago);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarPago(int Pago){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            FormaPagoEntity pago = em.find(FormaPagoEntity.class, Pago);
            if(pago !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(pago);
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
