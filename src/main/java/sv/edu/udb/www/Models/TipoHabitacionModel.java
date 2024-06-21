package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import sv.edu.udb.www.entities.TipoDocumentoEntity;
import sv.edu.udb.www.entities.TipoHabitacionEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class TipoHabitacionModel {
    public List<TipoHabitacionEntity> listarhabitacionestipo(){
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("TipoHabitacionEntity.findAll");
            List<TipoHabitacionEntity> lista = consulta.getResultList();
            return lista;
        } catch (Exception e) {
            // Manejo de excepciones
            return null;
        } finally {
            em.close();
        }
    }


    public TipoHabitacionEntity obtenerhabitacion(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TipoHabitacionEntity habitacion = em.find(TipoHabitacionEntity.class, id);
            return habitacion;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }

    public int insertarhabitacion(TipoHabitacionEntity habitacion){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(habitacion);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarHabitacionTipo(TipoHabitacionEntity habitacion){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(habitacion);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarHabitacionTipo(int id){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            TipoHabitacionEntity habitacion = em.find(TipoHabitacionEntity.class, id);
            if(habitacion !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(habitacion);
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
