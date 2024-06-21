package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.utils.JpaUtil;

public class LoginModel {
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
