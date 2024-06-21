package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.RolEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class RolModel {
    public List<RolEntity> listarRoles(){
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("rolEntity.findAll");
            List<RolEntity> lista = consulta.getResultList();
            return lista;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }
//ala

    public RolEntity obtenerRoles(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            RolEntity rol = em.find(RolEntity.class, id);
            return rol;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }

    public int insertarRol(RolEntity rol){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(rol);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarRol(RolEntity rol){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(rol);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarRol(int id){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            RolEntity rol = em.find(RolEntity.class, id);
            if(rol !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(rol);
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
