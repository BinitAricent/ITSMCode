/**************************************************************************
 
 **************************************************************************
 * Project: ITSM
 *
 * Class:   PollerProcessor
 *
 * Author:  TCL 
 *
 * Date:    06/06/2016
 *
 * Desc:    Poll Ticket IDs
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/
package com.aricent.eip.itsm.processors;

import java.util.Iterator;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aricent.eip.itsm.domains.ITSMTicketDetails;
import com.aricent.eip.itsm.domains.ITSMTicketDetails.ITSMStatus;
import com.aricent.eip.itsm.exception.RestWebServiceException;
import com.aricent.eip.itsm.exception.RoutingException;
import com.aricent.eip.itsm.logger.ITSMLogger;
import com.aricent.eip.itsm.service.ConsumeRestWebservice;

@Component
public class PollerProcessor {

    @Autowired
    private ProducerTemplate producer;

    @Autowired
    private ConsumeRestWebservice consumeRestWebservice;

    @Autowired
    ITSMLogger logger;

    @Value("${queue.ticketId}")
    String queueTicketId;

    @Value("${north.ticketId.rest.service}")
    String url;

    @Value("${north.service.userName}")
    String restServiceNowUserName;

    @Value("${north.service.password}")
    String restServiceNowPassword;


    public void poll() throws RoutingException {
        logger.info("PollerProcessor :: poll() ");

        String response = null;

        try {
            
            //consume ticket Ids from service now and store json array of ticket ids.
            response = consumeRestWebservice.getResponseFromService(url, String.class, restServiceNowUserName, restServiceNowPassword,
                    String.class);
            logger.info("PollerProcessor:: Poll() ::Ticketids=>" + response);

        } catch (RestWebServiceException e) {
            logger.severe("Unable to hit webservice while fetching ticket ids.");
            throw new RoutingException("PollerProcessor::Exception Unable to hit webservice while fetching ticket ids", e);
        }
        if (response != null) {

            logger.info("PollerProcess : reading ticketid from json ");
            
            JSONObject obj = new JSONObject(response);
            JSONArray detailInfo = obj.getJSONArray("result");
            Iterator<Object> it = detailInfo.iterator();
            while (it.hasNext()) {
                JSONObject obj1 = new JSONObject(it.next().toString());
                String ticketid = obj1.get("sys_id").toString();

                ITSMTicketDetails detail = new ITSMTicketDetails();
                try {

                    //Sending ticket id to queue
                    logger.info("PollerProcessor poll::Sending ticketid to queueTicketId");
                    producer.sendBody(queueTicketId, ticketid);

                } catch (CamelExecutionException exp) {
                    logger.info("PollerProcessor poll:: Exception occurred during sending message to id queue");
                    detail.setItsmstatus(ITSMStatus.FAILED_TO_PUSH_TO_ID_QUEUE);
                    throw new RoutingException("PollerProcessor::Exception occurred during sending message to id queue", exp);

                } finally {
                    logger.info("PollerProcessor poll::Sending detail to Database...");
                    // producer.sendBody("jpa://com.aricent.eip.itsm.domains.TicketDetails?usePersist=true", detail);

                }

            }

        }
    }
}