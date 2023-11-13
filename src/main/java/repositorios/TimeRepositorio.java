package repositorios;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Time;

import java.util.List;
public class TimeRepositorio {
	private EntityManagerFactory emf;

    public TimeRepositorio() {
        // Configure a unidade de persistência (persistence unit) no arquivo persistence.xml
        emf = Persistence.createEntityManagerFactory("FutebolOnline");
    }

    // Método para adicionar um novo estudante ao banco de dados
    public void adicionar(Time time) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(time);
        em.getTransaction().commit();
        em.close();
    }

    // Método para buscar um estudante pelo ID
    public Time buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Time time = em.find(Time.class, id);
        em.close();
        return time;
    }

    // Método para listar todos os estudantes no banco de dados
    public List<Time> listarTimes() {
        EntityManager em = emf.createEntityManager();
        List<Time> times = em.createQuery("SELECT t FROM Time t", Time.class).getResultList();
        em.close();
        return times;
    }

    // Método para atualizar um estudante
    public void atualizarTime(Time time) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(time);
        em.getTransaction().commit();
        em.close();
    }

    // Método para excluir um estudante
    public void excluirTime(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Time time = em.find(Time.class, id);
        if (time != null) {
            em.remove(time);
        }
        em.getTransaction().commit();
        em.close();
    }

    // Fechar o EntityManagerFactory quando não for mais necessário
    public void fecharEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}