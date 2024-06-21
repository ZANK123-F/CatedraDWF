package sv.edu.udb.www.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sv.edu.udb.www.entities.RolEntity;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.utils.JpaUtil;

public class RegistroModel {

    public int insertarUsuario(UsuarioEntity usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(usuario);
            tran.commit();
            return 1; // Indicar inserción exitosa
        } catch (Exception e) {
            if (tran.isActive()) {
                tran.rollback(); // Revertir la transacción si falla
            }
            e.printStackTrace(); // O manejar la excepción de otra manera
            return 0; // Indicar inserción fallida
        } finally {
            em.close(); // Cerrar el EntityManager después de la operación
        }

    }
    public RolEntity obtenerRolCliente() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(RolEntity.class, 3); // ID 3 para el rol de cliente
        } finally {
            em.close();
        }
    }

}
