/**************************************************************************

 **************************************************************************
 * Project: ITSM
 *
 * Class:   TicketDetailsITSM
 *
 * Author:  TCL 
 *
 * Date:    07/06/2016
 *
 * Desc:    Getters and setters for Service Now ticket details fields
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/
package com.aricent.eip.itsm.pojo;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "caller_id", "category", "short_description", "description", "priority", "opened_by", "contact_type", "location", "urgency", "u_affected_user", "subcategory"})

public class TicketDetailsSNOW implements Serializable{

	@Override
	public String toString() {
		return "DetailsServiceNow [caller_id=" + caller_id + ", category="
				+ category + ", short_description=" + short_description
				+ ", description=" + description + ", priority=" + priority
				+ ", opened_by=" + opened_by + ", contact_type=" + contact_type
				+ ", location=" + location + ", urgency=" + urgency
				+ ", u_affected_user=" + u_affected_user + ", subcategory="
				+ subcategory + ", sys_id=" + sys_id + "]";
	}
	
	@JsonProperty("caller_id")
    private Integer caller_id;
    @JsonProperty("category")
    private Integer category;
    @JsonProperty("short_description")
    private String short_description;
    @JsonProperty("description")
    private String description;
	@JsonProperty("priority")
    private Integer priority;
    @JsonProperty("opened_by")
    private String opened_by;
    @JsonProperty("contact_type")
    private String contact_type;
    @JsonProperty("location")
    private String location;
    @JsonProperty("urgency")
    private String urgency;
    @JsonProperty("u_affected_user")
    private Integer u_affected_user;
    @JsonProperty("subcategory")
    private String subcategory;
    @JsonProperty("sys_id")
    private String sys_id;
    
    @JsonProperty("sys_id")
    public String getSys_id() {
		return sys_id;
	}
    @JsonProperty("sys_id")
	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}
	@JsonProperty("caller_id")
    public Integer getCaller_id() {
		return caller_id;
	}
    @JsonProperty("caller_id")
	public void setCaller_id(Integer caller_id) {
		this.caller_id = caller_id;
	}
    
    @JsonProperty("category")
	public Integer getCategory() {
		return category;
	}
    @JsonProperty("category")
	public void setCategory(Integer category) {
		this.category = category;
	}
    
    @JsonProperty("short_description")
	public String getShort_description() {
		return short_description;
	}
    @JsonProperty("short_description")
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
    
    @JsonProperty("description")
	public String getDescription() {
		return description;
	}
    @JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
    
    @JsonProperty("priority")
	public Integer getPriority() {
		return priority;
	}
    @JsonProperty("priority")
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
    
    @JsonProperty("opened_by")
	public String getOpened_by() {
		return opened_by;
	}
    @JsonProperty("opened_by")
	public void setOpened_by(String opened_by) {
		this.opened_by = opened_by;
	}
    
    @JsonProperty("contact_type")
	public String getContact_type() {
		return contact_type;
	}
    @JsonProperty("contact_type")
	public void setContact_type(String contact_type) {
		this.contact_type = contact_type;
	}
    
    @JsonProperty("location")
	public String getLocation() {
		return location;
	}
    @JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}
    
    @JsonProperty("urgency")
	public String getUrgency() {
		return urgency;
	}
    @JsonProperty("urgency")
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
    
    @JsonProperty("u_affected_user")
	public Integer getU_affected_user() {
		return u_affected_user;
	}
    @JsonProperty("u_affected_user")
	public void setU_affected_user(Integer u_affected_user) {
		this.u_affected_user = u_affected_user;
	}
    
    @JsonProperty("subcategory")
	public String getSubcategory() {
		return subcategory;
	}
    @JsonProperty("subcategory")
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	    
}