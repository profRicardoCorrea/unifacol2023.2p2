package repositorios;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Cartao;
import entidades.Time;

import java.util.List;
public class CartaoRepositorio {
	private EntityManagerFactory emf;

    public CartaoRepositorio() {
        // Configure a unidade de persistência (persistence unit) no arquivo persistence.xml
        emf = Persistence.createEntityManagerFactory("FutebolOnline");
    }

    // Método para adicionar um novo estudante ao banco de dados
    public void adicionar(Cartao cartao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cartao);
        em.getTransaction().commit();
        em.close();
    }

    // Método para buscar um estudante pelo ID
    public Cartao buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Cartao cartao = em.find(Cartao.class, id);
        em.close();
        return cartao;
    }

    // Método para listar todos os estudantes no banco de dados
    public List<Cartao> listarCartoes() {
        EntityManager em = emf.createEntityManager();
        List<Cartao> cartoes = em.createQuery("SELECT t FROM Time t", Cartao.class).getResultList();
        em.close();
        return cartoes;
    }

    // Método para atualizar um estudante
    public void atualizarTime(Cartao cartao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cartao);
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
