package imeiv.webservice;

import java.util.List;

import javax.ejb.EJB;

import javax.ejb.Stateless;

import imeiv.ptamodel.PTASessionEJBLocal;

import imeiv.ptamodel.VwItemImeiInformation;


@Stateless


public class PTAIMEIImpl {


    @EJB(beanName = "PTASessionEJB")

    PTASessionEJBLocal mySessionBean;


    public List<VwItemImeiInformation> getVwItemImeiInformationFindByIMEI(String pimei1, String pimei2,
                                                                          String papikey) {

        return mySessionBean.getVwItemImeiInformationFindByIMEI(pimei1, pimei2, papikey);

    }

}
