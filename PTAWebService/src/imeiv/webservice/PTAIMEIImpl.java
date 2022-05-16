package imeiv.webservice;

import java.util.List;

import javax.ejb.EJB;

import javax.ejb.Stateless;

import imeiv.ptamodel.PTASessionEJBLocal;

import imeiv.ptamodel.VwItemImeiInformation;
import imeiv.ptamodel.PTARequestResult;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Stateless
@Path("webservice")
@Consumes("application/json")
@Produces("application/json")


public class PTAIMEIImpl {


    @EJB(beanName = "PTASessionEJB")

    PTASessionEJBLocal mySessionBean;


    @GET
    @Produces("application/json")
    @Path("/getone")
    public List<PTARequestResult> getVwItemImeiInformationFindByIMEI(@QueryParam("pimei1") String pimei1,
                                                                     @QueryParam("pimei2") String pimei2,
                                                                     @QueryParam("papikey") String papikey) {
        List<VwItemImeiInformation> limeiinfo=mySessionBean.getVwItemImeiInformationFindByIMEI(pimei1, pimei2, papikey);
        
        PTARequestResult ptares=null;
        if (limeiinfo.isEmpty()) {
           if (papikey==null || !papikey.equals("D$pL0y@cC$sSk$y")) {///for invalid key
               ptares=new PTARequestResult(0,401,"Unauthorized Request, api key is missing/invalid");         
           }
           else
           if (pimei1==null || pimei1.length()<=13 ||pimei2==null || pimei2.length()<=13)  {///for invalid key
               ptares=new PTARequestResult(0,406,"Invalid or empty IMEI");         
           } 
           
           else
           {
               ptares=new PTARequestResult(0,404,"Resource Not found");         
           
           }
       }
        else {
            ptares=new PTARequestResult(1,200,"Operation Successful.");    
        }
//        VwItemImeiInformation info=limeiinfo.get(0);
        
        List<PTARequestResult> item=new ArrayList<PTARequestResult>();
        item.add(ptares);
        
        return item;


    }

}
