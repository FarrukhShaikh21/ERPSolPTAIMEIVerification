package imeiv.ptamodel;

import java.util.List;

import javax.ejb.Local;

@Local
public interface PTASessionEJBLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    List<VwItemImeiInformation> getVwItemImeiInformationFindByIMEI(String pimei1, String pimei2, String papikey);
}
