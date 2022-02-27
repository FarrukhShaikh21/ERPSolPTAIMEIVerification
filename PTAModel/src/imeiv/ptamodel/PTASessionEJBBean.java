package imeiv.ptamodel;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "PTASessionEJB", mappedName = "ERPSolPTAImeiVerification-PTAModel-PTASessionEJB")
public class PTASessionEJBBean implements PTASessionEJBLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "PTAModel")
    private EntityManager em;

    public PTASessionEJBBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    /** <code>select o from VwItemImeiInformation o where o.imei1=:pimei1 and o.imei2=:pimei2 and o.apikey=:papikey</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VwItemImeiInformation> getVwItemImeiInformationFindByIMEI(String pimei1, String pimei2,
                                                                          String papikey) {
        return em.createNamedQuery("VwItemImeiInformation.findByIMEI",
                                   VwItemImeiInformation.class).setParameter("pimei1", pimei1).setParameter("pimei2",
                                                                                                            pimei2).setParameter("papikey",
                                                                                                                                 papikey).getResultList();
    }
}
