package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.ReservaEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class ReservaModel {
    public List<ReservaEntity> listarReserva(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("ReservaEntity.findAll");
            List<ReservaEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public ReservaEntity obtenerReserva(int id){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            ReservaEntity reserva = em.find(ReservaEntity.class, id);
            em.close();
            return  reserva;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarReserva(ReservaEntity reserva){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(reserva);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarReserva(ReservaEntity reserva){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(reserva);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarReserva(int id){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            ReservaEntity reserva = em.find(ReservaEntity.class, id);
            if(reserva !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(reserva);
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
