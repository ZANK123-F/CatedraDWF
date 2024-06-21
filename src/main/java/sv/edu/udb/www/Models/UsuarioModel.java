package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class UsuarioModel {
    public List<UsuarioEntity> listarusuarios(){
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsuarioEntity.findAll");
            List<UsuarioEntity> lista = consulta.getResultList();
            return lista;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }


    public UsuarioEntity obtenerUsuarios(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            UsuarioEntity usuario = em.find(UsuarioEntity.class, id);
            return usuario;
        } catch (Exception e) {

            return null;
        } finally {
            em.close();
        }
    }

    public int insertarUsuarios(UsuarioEntity usuario){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(usuario);
            tran.commit();
            return 1; // Indicar inserción exitosa
        } catch(Exception e){
            if (tran.isActive()) {
                tran.rollback(); // Revertir la transacción si falla
            }
            e.printStackTrace(); // O manejar la excepción de otra manera
            return 0; // Indicar inserción fallida
        } finally {
            em.close(); // Cerrar el EntityManager después de la operación
        }
    }


    public int modificarUsuarios(UsuarioEntity usuario){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(usuario);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarUsuarios(int id){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            UsuarioEntity usuario = em.find(UsuarioEntity.class, id);
            if(usuario !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(usuario);
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
    public UsuarioEntity verificarCredenciales(String correo, String contrasenia) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM UsuarioEntity u WHERE u.correo = :correo AND u.contrasenia = :contrasenia", UsuarioEntity.class);
            query.setParameter("correo", correo);
            query.setParameter("contrasenia", contrasenia);
            return (UsuarioEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontró ningún usuario con las credenciales proporcionadas
        } finally {
            em.close();
        }
    }

}
