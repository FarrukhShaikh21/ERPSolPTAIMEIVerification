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
import javax.ws.rs.POST;
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


    @POST
    @Produces("application/json")
    @Path("/getone")
    
    public List<PTARequestResult> getVwItemImeiInformationFindByIMEI(String pbody) {
        /*
        String papikey="D$pL0y@cC$sSk$y";
        String pimei2="357748680150995";
        String pimei1="357748680000992";
        
        System.out.println(pbody);*/
        String finalkey="";
        String finalimei2="";
        String finalimei="";

        try {
            int imei1k = pbody.indexOf("\"imei\"");
            int imei1v = pbody.indexOf("\"", imei1k + 7);
            int imti1vstr = pbody.indexOf("\"", imei1v + 1);
            String strimei1 = pbody.substring(imei1k, imti1vstr + 1);
            System.out.println(strimei1);

            int imei2k = pbody.indexOf("\"imei_2\"");
            int imei2v = pbody.indexOf("\"", imei2k + 8);
            int imti2vstr = pbody.indexOf("\"", imei2v + 1);
            String strime21 = pbody.substring(imei2k, imti2vstr + 1);
            System.out.println(strime21);

            int keyk = pbody.indexOf("\"api_key\"");
            int keyv = pbody.indexOf("\"", keyk + 9);
            int keyvstr = pbody.indexOf("\"", keyv + 1);
            String strkey1 = pbody.substring(keyk, keyvstr + 1);
            System.out.println(strkey1);


            System.out.println(strimei1);
            int finalimeiindex = strimei1.indexOf("\"", 6);
            finalimei = strimei1.substring(finalimeiindex).replaceAll("\"", "");
            System.out.println(finalimei);


            int finalimei2index = strime21.indexOf("\"", 8);
            finalimei2 = strime21.substring(finalimei2index).replaceAll("\"", "");
            System.out.println(finalimei2);


            int finalfinalkeyindex = strkey1.indexOf("\"", 9);
            finalkey = strkey1.substring(finalfinalkeyindex).replaceAll("\"", "");
            System.out.println(finalkey);
        } catch (Exception e) {
            // TODO: Add catch code
            finalimei="ERPBR";
            finalimei2="ERPBR";
            finalkey="ERPBR";
        }
        
        String papikey=finalkey;
        String pimei2=finalimei2;
        String pimei1=finalimei;
        
        List<VwItemImeiInformation> limeiinfo=mySessionBean.getVwItemImeiInformationFindByIMEI(pimei1, pimei2, papikey);
        
        PTARequestResult ptares=null;
        if (limeiinfo.isEmpty()) {
           if (papikey!=null &&papikey.equals("ERPBR")) {///for invalid key
               ptares=new PTARequestResult(0,400,"Bad Request",null,null,null);         
           }
           else
           if (papikey==null || !papikey.equals("D$pL0y@cC$sSk$y")) {///for invalid key
               ptares=new PTARequestResult(0,401,"Unauthorized Request, api key is missing/invalid",null,null,null);         
           }
           else
           if (pimei1==null || pimei1.length()<=13 ||pimei2==null || pimei2.length()<=13)  {///for invalid key
               ptares=new PTARequestResult(0,406,"Invalid or empty IMEI",null,null,null);         
           } 
           
           else
           {
               ptares=new PTARequestResult(0,404,"Resource Not found",null,null,null);         
           
           }
       }
        else {
            VwItemImeiInformation info=limeiinfo.get(0);
            System.out.println(info.getColor());
            ptares=new PTARequestResult(1,200,"Operation Successful.",info.getSerialNo(),info.getColor(),info.getIsAssembled()); 
        }
//        VwItemImeiInformation info=limeiinfo.get(0);
        
        List<PTARequestResult> item=new ArrayList<PTARequestResult>();
        item.add(ptares);
        
        return item;


    }

}
