
/**************************************************************************

 **************************************************************************
 * Project: ITSM
 *
 * Class:   TicketDetails
 *
 * Author:  TCL 
 *
 * Date:    07/06/2016
 *
 * Desc:    Entity class for storing ITSM ticket details in database
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
@Table(name = "ITSMTicketDetails")
public class ITSMTicketDetails {

	@Id
	private String external_refernece_id;
	
	private String ticketId; 
	
    @Column(columnDefinition = "TEXT")
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@Enumerated(EnumType.STRING)
	private ITSMStatus itsmstatus;

	public enum ITSMStatus {
		NEW, FAILED_TO_PUSH_TO_ID_QUEUE, FAILED_TO_FETCH_DETAILS, FAILED_TO_PUSH_TO_DETAILS_QUEUE, FAILED_TO_CREATE_ON_ENDPOINT
	}

	public ITSMTicketDetails() {
	};

	@Size(min = 3)
	public String getExternal_refernece_id() {
		return external_refernece_id;
	}

	public void setExternal_refernece_id(String external_refernece_id) {
		this.external_refernece_id = external_refernece_id;
	}
	
	@Size(min = 3)
	public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }


	@Size(min = 3)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Size(min = 3)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Enumerated(EnumType.STRING)
	public ITSMStatus getItsmstatus() {
		return itsmstatus;
	}

	@Enumerated(EnumType.STRING)
	public void setItsmstatus(ITSMStatus itsmstatus) {
		this.itsmstatus = itsmstatus;
	}

}
