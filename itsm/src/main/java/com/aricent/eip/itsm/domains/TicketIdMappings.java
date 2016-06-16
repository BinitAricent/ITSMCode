/**************************************************************************

 **************************************************************************
 * Project: ITSM
 *
 * Class:   TicketIdMappings
 *
 * Author:  TCL 
 *
 * Date:    07/06/2016
 *
 * Desc:    Entity class for storing ITSM ticket id and external reference id in database
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/
package com.aricent.eip.itsm.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TicketIdMappings")
public class TicketIdMappings {

    private int mId;
    private String ITSM_ID;
    private String SNOW_ID;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getmId() {
        return mId;
    }


    public void setmId(int mId) {
        this.mId = mId;
    }


    @Size(min = 3)
    public String getITSM_ID() {
        return ITSM_ID;
    }


    public void setITSM_ID(String iTSM_ID) {
        ITSM_ID = iTSM_ID;
    }


    @Size(min = 3)
    public String getSNOW_ID() {
        return SNOW_ID;
    }


    public void setSNOW_ID(String sNOW_ID) {
        SNOW_ID = sNOW_ID;
    }
}
