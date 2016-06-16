/**************************************************************************

 **************************************************************************
 * Project: ITSM
 *
 * Class:   ServiceNowTicketDetailProcessor
 *
 * Author:  TCL 
 *
 * Date:    07/06/2016
 *
 * Desc:    Poll Ticket Details
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/
package com.aricent.eip.itsm.processors;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aricent.eip.itsm.domains.SNOWTicketDetails;
import com.aricent.eip.itsm.domains.SNOWTicketDetails.ServiceNowStatus;
import com.aricent.eip.itsm.exception.RestWebServiceException;
import com.aricent.eip.itsm.logger.ITSMLogger;
import com.aricent.eip.itsm.pojo.TicketDetailsSNOW;
import com.aricent.eip.itsm.service.ConsumeRestWebservice;

@Component
public class ServiceNowTicketDetailProcessor implements Processor {

    @Value("${north.ticketDetails.rest.service}")
    private String getUrl;

    @Value("${north.service.userName}")
    String restServiceNowUserName;

    @Value("${north.service.password}")
    String restServiceNowPassword;

    @Autowired
    private ProducerTemplate producer;

    @Autowired
    ConsumeRestWebservice consumeRestWebservice;
    
    @Autowired
    ITSMLogger logger;

    public void process(Exchange exchange) throws RestWebServiceException {
        
        String serviceNowSysId = exchange.getIn().getBody(String.class);

        String response = null;
        JSONObject jsonObject;
        TicketDetailsSNOW detailObje = new TicketDetailsSNOW();
        try {

            String tempURL = getUrl.replace("{ticketId}", serviceNowSysId);
            
            //consume ticket details from Service Now
            response = consumeRestWebservice.getResponseFromService(tempURL, String.class, restServiceNowUserName, restServiceNowPassword,
                    String.class);

            logger.info("ticketDetailsServiceNow =>" + response);
            jsonObject = new JSONObject(response);
            
            //Fetch mapping fields from response
            JSONObject detailInfo = jsonObject.getJSONObject("result");
            detailObje.setDescription(detailInfo.get("description").toString());
            detailObje.setSys_id(detailInfo.get("sys_id").toString());
            detailObje.setShort_description(detailInfo.get("short_description").toString());

            //Set Service Now Ticket details and send them to Database
            SNOWTicketDetails snowDetails = new SNOWTicketDetails();
            snowDetails.setSys_id(detailInfo.get("sys_id").toString());
            snowDetails.setDescription(detailInfo.get("description").toString());
            snowDetails.setShort_description(detailInfo.get("short_description").toString());
            snowDetails.setSnowStatus(ServiceNowStatus.NEW);

            try {
                producer.sendBody("jpa://com.aricent.eip.itsm.domains.SNOWTicketDetails?usePersist=true", snowDetails);
            } catch (CamelExecutionException e) {
                e.printStackTrace();
            }

            logger.info("Service Now Processor-----Ticket details are" + detailObje.toString());

            exchange.getIn().setBody(detailObje);

        } catch (RestWebServiceException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
