/**************************************************************************

 **************************************************************************
 * Project: ITSM
 *
 * Class:   ITSMTicketCreatorProcessor
 *
 * Author:  TCL 
 *
 * Date:    07/06/2016
 *
 * Desc:    Create ticket in ITSM
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

import com.aricent.eip.itsm.domains.ITSMTicketDetails;
import com.aricent.eip.itsm.domains.ITSMTicketDetails.ITSMStatus;
import com.aricent.eip.itsm.domains.TicketIdMappings;
import com.aricent.eip.itsm.exception.RestWebServiceException;
import com.aricent.eip.itsm.logger.ITSMLogger;
import com.aricent.eip.itsm.pojo.TicketDetailsITSM;
import com.aricent.eip.itsm.service.ConsumeRestWebservice;

@Component
public class ITSMTicketCreaterProcessor implements Processor {

    @Autowired
    private ProducerTemplate producer;

    @Autowired
    ConsumeRestWebservice consumeRestWebservice;

    @Value("${south.service.userName}")
    String restServiceUserName;

    @Value("${south.service.password}")
    String restServicePassword;

    @Value("${south.service.create.url}")
    String restServiceUrl;

    @Autowired
    ITSMLogger logger;

    @Value("${itsm.CustomerId}")
    String customerId;
    @Value("${itsm.EngagementId}")
    String engagementId;
    @Value("${itsm.ReportedIssuetypeId}")
    String reportedIssuetypeId;
    @Value("${itsm.CiId}")
    String ciId;
    @Value("${itsm.PriorityId}")
    String priorityId;
    @Value("${itsm.Requestor}")
    String requestor;
    @Value("${itsm.RequestorEmail}")
    String requestorEmail;
    @Value("${itsm.RequestorPhone}")
    String requestorPhone;
    @Value("${itsm.TicketSourceId}")
    String ticketSourceId;


    @Override
    public void process(Exchange arg0) throws Exception {

       
        logger.info("-ITSM Ticket Creation Processor----------------->>>>>>>>>>>>>>" + arg0.getIn().getBody().toString());

        TicketDetailsITSM ticketDetailsITSM = arg0.getIn().getBody(TicketDetailsITSM.class);
        logger.info("In ITSM Ticket Creation Processor tiketDetails are ----------------->>>>>>>>>>>>>>" + ticketDetailsITSM);

        //set fixed fields of ITSM
        ticketDetailsITSM.setCustomerId(Integer.parseInt(customerId));
        ticketDetailsITSM.setEngagementId(Integer.parseInt(engagementId));
        ticketDetailsITSM.setReportedIssuetypeId(Integer.parseInt(reportedIssuetypeId));
        ticketDetailsITSM.setCiId(Integer.parseInt(ciId));
        ticketDetailsITSM.setPriorityId(Integer.parseInt(priorityId));
        ticketDetailsITSM.setRequestor(requestor);
        ticketDetailsITSM.setRequestorEmail(requestorEmail);
        ticketDetailsITSM.setRequestorPhone(requestorPhone);
        ticketDetailsITSM.setTicketSourceId(Integer.parseInt(ticketSourceId));

        String response = null;
        ITSMTicketDetails details = new ITSMTicketDetails();
        String ticketId = null;
        try {
            
            //creation of ticket request in ITSM.
            response = consumeRestWebservice.postRequestToService(restServiceUrl, String.class, restServiceUserName, restServicePassword,
                    ticketDetailsITSM);
            
            logger.info("ITSM ticket creation response : " + response);
            JSONObject jsonObject = new JSONObject(response);
            JSONObject ticketResponse = jsonObject.getJSONObject("data");
            ticketId = ticketResponse.get("ticketId").toString();

            logger.info("ITSM ticket Id" + ticketId);
            
            details.setTicketId(ticketId);
            details.setDescription(ticketDetailsITSM.getDescription());
            details.setTitle(ticketDetailsITSM.getTitle());
            details.setExternal_refernece_id(ticketDetailsITSM.getExternal_refernece_id());
            details.setItsmstatus(ITSMStatus.NEW);
            
            //Send ITSM ticket details to Database
            producer.sendBody("jpa://com.aricent.eip.itsm.domains.ITSMTicketDetails", details);

        } catch (RestWebServiceException re) {
            details.setItsmstatus(ITSMStatus.FAILED_TO_CREATE_ON_ENDPOINT);

            //send ITSM ticket details to database in case of ITSM POST rest service failure
            producer.sendBody("jpa://com.aricent.eip.itsm.domains.TicketDetails", details);

            logger.severe(re.getMessage());
            logger.info("Error fetching tickets info while sending ticket detail " + restServiceUrl);
            throw new RestWebServiceException("Error fetching tickets info for " + restServiceUrl, re);
        }
        
        TicketIdMappings mapping = new TicketIdMappings();
        mapping.setITSM_ID(ticketId);
        mapping.setSNOW_ID(ticketDetailsITSM.getExternal_refernece_id());

        try {
            //send ITSM ticket id and external reference id to database mapping table.
            producer.sendBody("jpa://com.aricent.eip.itsm.domains.TicketIdMappings?usePersist=true", mapping);
        } catch (CamelExecutionException ee) {
            logger.severe(ee.getMessage());
        }

    }
}
