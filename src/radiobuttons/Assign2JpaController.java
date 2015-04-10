/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package radiobuttons;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import radiobuttons.exceptions.NonexistentEntityException;
import radiobuttons.exceptions.PreexistingEntityException;

/**
 *
 * @author Abednigo
 */
public class Assign2JpaController implements Serializable {

    public Assign2JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Assign2 assign2) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(assign2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAssign2(assign2.getTeamname()) != null) {
                throw new PreexistingEntityException("Assign2 " + assign2 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Assign2 assign2) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            assign2 = em.merge(assign2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = assign2.getTeamname();
                if (findAssign2(id) == null) {
                    throw new NonexistentEntityException("The assign2 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assign2 assign2;
            try {
                assign2 = em.getReference(Assign2.class, id);
                assign2.getTeamname();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The assign2 with id " + id + " no longer exists.", enfe);
            }
            em.remove(assign2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Assign2> findAssign2Entities() {
        return findAssign2Entities(true, -1, -1);
    }

    public List<Assign2> findAssign2Entities(int maxResults, int firstResult) {
        return findAssign2Entities(false, maxResults, firstResult);
    }

    private List<Assign2> findAssign2Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Assign2.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Assign2 findAssign2(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Assign2.class, id);
        } finally {
            em.close();
        }
    }

    public int getAssign2Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Assign2> rt = cq.from(Assign2.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
