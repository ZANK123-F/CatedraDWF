package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.HabitacionEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class HabitacionModel {
    public List<HabitacionEntity> listarhabitaciones(){
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("HabitacionEntity.findAll");
            List<HabitacionEntity> lista = consulta.getResultList();
            return lista;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }
//ala

    public HabitacionEntity obtenerhabitacion(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            HabitacionEntity habitacion = em.find(HabitacionEntity.class, id);
            return habitacion;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }

    public int insertarhabitacion(HabitacionEntity habitacion){
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

    public int modificarHabitacion(HabitacionEntity habitacion){
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
    public int eliminarHabitacion(int id){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            HabitacionEntity habitacion = em.find(HabitacionEntity.class, id);
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
