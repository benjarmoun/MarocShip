import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class main {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tr;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }
}
