/**************************************************************************

 **************************************************************************
 * Project: ITSM
 *
 * Class:   ServiceNowTicketDetails
 *
 * Author:  TCL 
 *
 * Date:    07/06/2016
 *
 * Desc:    Entity class for storing Service Now ticket details in database
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/
package com.aricent.eip.itsm.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SNOWTicketDetails")
public class SNOWTicketDetails {

    @Id
    private String sys_id;

    @Column(columnDefinition = "TEXT")
    private String short_description;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceNowStatus snowStatus;

    public enum ServiceNowStatus {
        NEW, FAILED_TO_PUSH_TO_ID_QUEUE, FAILED_TO_FETCH_DETAILS, FAILED_TO_PUSH_TO_DETAILS_QUEUE, FAILED_TO_CREATE_ON_ENDPOINT
    }


    public SNOWTicketDetails() {
    };


    @Size(min = 3)
    public String getSys_id() {
        return sys_id;
    }


    public void setSys_id(String sys_id) {
        this.sys_id = sys_id;
    }


    @Size(min = 3)
    public String getShort_description() {
        return short_description;
    }


    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }


    @Size(min = 3)
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @Enumerated(EnumType.STRING)
    public ServiceNowStatus getSnowStatus() {
        return snowStatus;
    }


    @Enumerated(EnumType.STRING)
    public void setSnowStatus(ServiceNowStatus snowStatus) {
        this.snowStatus = snowStatus;
    }

}
