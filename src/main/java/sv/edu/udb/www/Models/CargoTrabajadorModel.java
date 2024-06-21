package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.CargoTrabajadorEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class CargoTrabajadorModel {

    public List<CargoTrabajadorEntity> listarcargoTrabajador(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("CargoTrabajadorEntity.findAll");
            List<CargoTrabajadorEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public CargoTrabajadorEntity obtenercargoTrabajador(int id){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            CargoTrabajadorEntity cargotrabajador = em.find(CargoTrabajadorEntity.class, id);
            em.close();
            return  cargotrabajador;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarTrabajador(CargoTrabajadorEntity cargotrabajador){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(cargotrabajador);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarcargoTrabajador(CargoTrabajadorEntity cargotrabajador){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(cargotrabajador);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarcargoTrabajador(int cargotrabajador){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            CargoTrabajadorEntity trabajador = em.find(CargoTrabajadorEntity.class, cargotrabajador);
            if(trabajador !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(trabajador);
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
