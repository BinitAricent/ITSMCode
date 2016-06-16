/**************************************************************************
 
 **************************************************************************
 * Project: ITSM
 *
 * Class:   ConsumerRestWebservice
 *
 * Author:  TCL 
 *
 * Date:    07/05/2016
 *
 * Desc:    Get response and Post request from REST Services
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/
package com.aricent.eip.itsm.service;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.aricent.eip.itsm.exception.RestWebServiceException;
import com.aricent.eip.itsm.logger.ITSMLogger;

@Service
public class ConsumeRestWebservice {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ITSMLogger logger;
 
    //Method for posting request to service
    public <T, R> T postRequestToService(String url, Class<T> responseType, String userName, String password, R request)
            throws RestWebServiceException {

        logger.info("ConsumeRestWebservice:: consumeRestws(" + url + ")"); 
        
        HttpHeaders headers=authorization(userName,password);

        HttpEntity<R> httpEntity = new HttpEntity<R>(request, headers);
        ResponseEntity<T> response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseType);

        } catch (RestClientException re) {
            throw new RestWebServiceException("Error fetching tickets info for " + url, re);
        }
        return response.getBody();
    }


    //Method for getting response from service
    public <T, R> T getResponseFromService(String url, Class<T> responseType, String userName, String password, R request)
            throws RestWebServiceException {

        logger.info("Consume Service Now:: consumeRestws(" + url + ")"); 
        
        HttpHeaders headers=authorization(userName,password);
        
        HttpEntity<R> httpEntity = new HttpEntity<R>(request, headers);
        ResponseEntity<T> response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType);

        } catch (RestClientException re) {
            throw new RestWebServiceException("Error fetching tickets info for " + url, re);
        }
        return response.getBody();
    }
    
    private HttpHeaders authorization(String userName,String password)
    {
        String plainCreds = userName + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;

    }

}
