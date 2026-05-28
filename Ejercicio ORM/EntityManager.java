package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class EntityManager {

    // Instancias oficiales de Jakarta para manejar la base de datos internamente
    private EntityManagerFactory emf;
    private jakarta.persistence.EntityManager em;

    // Metodo para abrir la conexión a la base de datos (como el createEntityManagerFactory del PDF)
    public void conectar() {
        if (emf == null || !emf.isOpen()) {
            this.emf = Persistence.createEntityManagerFactory("miUnidad");
            this.em = emf.createEntityManager();
        }
    }

    // Metodo para guardar un Pou nuevo por primera vez (Crear)
    public void guardarPou(Pou pou) {
        em.getTransaction().begin();
        em.persist(pou);
        em.getTransaction().commit();
    }

    // Metodo para buscar tu Pou guardado mediante su ID (Leer)
    public Pou buscarPou(int id) {
        return em.find(Pou.class, id);
    }

    // Metodo para actualizar los estados del Pou tras comer, jugar o bañarse (Editar)
    public void actualizarPou(Pou pou) {
        em.getTransaction().begin();
        pou.verificarLimites(); // Asegura que ningún atributo pase de 100 ni baje de 0
        em.merge(pou);          // Guarda los cambios en la base de datos
        em.getTransaction().commit();
    }

    // Metodo para registrar alimentos iniciales en la base de datos si la tabla está vacía
    public void registrarAlimento(Alimento alimento) {
        em.getTransaction().begin();
        em.persist(alimento);
        em.getTransaction().commit();
    }

    // Metodo para traer la lista completa de alimentos disponibles de la base de datos
    public List<Alimento> obtenerTodosLosAlimentos() {
        return em.createQuery("FROM Alimento", Alimento.class).getResultList();
    }

    // Metodo para cerrar las conexiones de forma limpia (como el close del PDF)
    public void desconectar() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
