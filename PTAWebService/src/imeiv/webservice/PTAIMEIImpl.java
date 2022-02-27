package imeiv.webservice;

import java.util.List;

import javax.ejb.EJB;

import javax.ejb.Stateless;

import imeiv.ptamodel.PTASessionEJBLocal;

import imeiv.ptamodel.VwItemImeiInformation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Stateless
@Path("webservice")
@Consumes("application/json")


public class PTAIMEIImpl {


    @EJB(beanName = "PTASessionEJB")

    PTASessionEJBLocal mySessionBean;


    @GET
    @Produces("application/json")
    @Path("/")
    public List<VwItemImeiInformation> getVwItemImeiInformationFindByIMEI(@QueryParam("pimei1") String pimei1,
                                                                          @QueryParam("pimei2") String pimei2,
                                                                          @QueryParam("papikey") String papikey) {

        return mySessionBean.getVwItemImeiInformationFindByIMEI(pimei1, pimei2, papikey);

    }

}
