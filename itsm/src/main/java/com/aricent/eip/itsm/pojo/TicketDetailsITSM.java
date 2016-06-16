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
 * Desc:    Getters and setters for ITSM ticket details fields
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/
package com.aricent.eip.itsm.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "customerId", "engagementId", "reportedIssuetypeId", "ciId", "title", "description", "priorityId", "requestor",
        "requestorEmail", "requestorPhone", "requestorCCEmail", "ticketSourceId", "supportTypeId", "createdBy", "urgencyId", "impactId",
        "relatedCiIds", "faqs", "attachments", "reachedBy", "ticketCategory" })
public class TicketDetailsITSM implements Serializable{

    @Override
    public String toString() {
        return "TicketDetailsITSM [customerId=" + customerId + ", engagementId=" + engagementId + ", reportedIssuetypeId="
                + reportedIssuetypeId + ", ciId=" + ciId + ", title=" + title + ", description=" + description + ", priorityId="
                + priorityId + ", requestor=" + requestor + ", requestorEmail=" + requestorEmail + ", requestorPhone=" + requestorPhone
                + ", requestorCCEmail=" + requestorCCEmail + ", ticketSourceId=" + ticketSourceId + ", supportTypeId=" + supportTypeId
                + ", createdBy=" + createdBy + ", urgencyId=" + urgencyId + ", impactId=" + impactId + ", relatedCiIds=" + relatedCiIds
                + ", faqs=" + faqs + ", attachments=" + attachments + ", reachedBy=" + reachedBy + ", ticketCategory=" + ticketCategory
                + ", additionalProperties=" + additionalProperties + "]";
    }

    @JsonProperty("customerId")
    private Integer customerId;
    @JsonProperty("engagementId")
    private Integer engagementId;
    @JsonProperty("reportedIssuetypeId")
    private Integer reportedIssuetypeId;
    @JsonProperty("ciId")
    private Integer ciId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("priorityId")
    private Integer priorityId;
    @JsonProperty("requestor")
    private String requestor;
    @JsonProperty("requestorEmail")
    private String requestorEmail;
    @JsonProperty("requestorPhone")
    private String requestorPhone;
    @JsonProperty("requestorCCEmail")
    private String requestorCCEmail;
    @JsonProperty("ticketSourceId")
    private Integer ticketSourceId;
    @JsonProperty("supportTypeId")
    private Integer supportTypeId;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("urgencyId")
    private Integer urgencyId;
    @JsonProperty("impactId")
    private Integer impactId;
    @JsonProperty("relatedCiIds")
    @Valid
    private List<Object> relatedCiIds = new ArrayList<Object>();
    @JsonProperty("faqs")
    @Valid
    private List<Object> faqs = new ArrayList<Object>();
    @JsonProperty("attachments")
    @Valid
    private List<Object> attachments = new ArrayList<Object>();
    @JsonProperty("reachedBy")
    private String reachedBy;
    @JsonProperty("ticketCategory")
    private String ticketCategory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
    @JsonProperty("external_refernece_id")
    private String external_refernece_id;

    
    @JsonProperty("external_refernece_id")
    public String getExternal_refernece_id() {
		return external_refernece_id;
	}

    @JsonProperty("external_refernece_id")
	public void setExternal_refernece_id(String external_refernece_id) {
		this.external_refernece_id = external_refernece_id;
	}

	/**
     * 
     * @return The customerId
     */
    @JsonProperty("customerId")
    public Integer getCustomerId() {
        return customerId;
    }


    /**
     * 
     * @param customerId The customerId
     */
    @JsonProperty("customerId")
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    /**
     * 
     * @return The engagementId
     */
    @JsonProperty("engagementId")
    public Integer getEngagementId() {
        return engagementId;
    }


    /**
     * 
     * @param engagementId The engagementId
     */
    @JsonProperty("engagementId")
    public void setEngagementId(Integer engagementId) {
        this.engagementId = engagementId;
    }


    /**
     * 
     * @return The reportedIssuetypeId
     */
    @JsonProperty("reportedIssuetypeId")
    public Integer getReportedIssuetypeId() {
        return reportedIssuetypeId;
    }


    /**
     * 
     * @param reportedIssuetypeId The reportedIssuetypeId
     */
    @JsonProperty("reportedIssuetypeId")
    public void setReportedIssuetypeId(Integer reportedIssuetypeId) {
        this.reportedIssuetypeId = reportedIssuetypeId;
    }


    /**
     * 
     * @return The ciId
     */
    @JsonProperty("ciId")
    public Integer getCiId() {
        return ciId;
    }


    /**
     * 
     * @param ciId The ciId
     */
    @JsonProperty("ciId")
    public void setCiId(Integer ciId) {
        this.ciId = ciId;
    }


    /**
     * 
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }


    /**
     * 
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * 
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }


    /**
     * 
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * 
     * @return The priorityId
     */
    @JsonProperty("priorityId")
    public Integer getPriorityId() {
        return priorityId;
    }


    /**
     * 
     * @param priorityId The priorityId
     */
    @JsonProperty("priorityId")
    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }


    /**
     * 
     * @return The requestor
     */
    @JsonProperty("requestor")
    public String getRequestor() {
        return requestor;
    }


    /**
     * 
     * @param requestor The requestor
     */
    @JsonProperty("requestor")
    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }


    /**
     * 
     * @return The requestorEmail
     */
    @JsonProperty("requestorEmail")
    public String getRequestorEmail() {
        return requestorEmail;
    }


    /**
     * 
     * @param requestorEmail The requestorEmail
     */
    @JsonProperty("requestorEmail")
    public void setRequestorEmail(String requestorEmail) {
        this.requestorEmail = requestorEmail;
    }


    /**
     * 
     * @return The requestorPhone
     */
    @JsonProperty("requestorPhone")
    public String getRequestorPhone() {
        return requestorPhone;
    }


    /**
     * 
     * @param requestorPhone The requestorPhone
     */
    @JsonProperty("requestorPhone")
    public void setRequestorPhone(String requestorPhone) {
        this.requestorPhone = requestorPhone;
    }


    /**
     * 
     * @return The requestorCCEmail
     */
    @JsonProperty("requestorCCEmail")
    public String getRequestorCCEmail() {
        return requestorCCEmail;
    }


    /**
     * 
     * @param requestorCCEmail The requestorCCEmail
     */
    @JsonProperty("requestorCCEmail")
    public void setRequestorCCEmail(String requestorCCEmail) {
        this.requestorCCEmail = requestorCCEmail;
    }


    /**
     * 
     * @return The ticketSourceId
     */
    @JsonProperty("ticketSourceId")
    public Integer getTicketSourceId() {
        return ticketSourceId;
    }


    /**
     * 
     * @param ticketSourceId The ticketSourceId
     */
    @JsonProperty("ticketSourceId")
    public void setTicketSourceId(Integer ticketSourceId) {
        this.ticketSourceId = ticketSourceId;
    }


    /**
     * 
     * @return The supportTypeId
     */
    @JsonProperty("supportTypeId")
    public Integer getSupportTypeId() {
        return supportTypeId;
    }


    /**
     * 
     * @param supportTypeId The supportTypeId
     */
    @JsonProperty("supportTypeId")
    public void setSupportTypeId(Integer supportTypeId) {
        this.supportTypeId = supportTypeId;
    }


    /**
     * 
     * @return The createdBy
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }


    /**
     * 
     * @param createdBy The createdBy
     */
    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * 
     * @return The urgencyId
     */
    @JsonProperty("urgencyId")
    public Integer getUrgencyId() {
        return urgencyId;
    }


    /**
     * 
     * @param urgencyId The urgencyId
     */
    @JsonProperty("urgencyId")
    public void setUrgencyId(Integer urgencyId) {
        this.urgencyId = urgencyId;
    }


    /**
     * 
     * @return The impactId
     */
    @JsonProperty("impactId")
    public Integer getImpactId() {
        return impactId;
    }


    /**
     * 
     * @param impactId The impactId
     */
    @JsonProperty("impactId")
    public void setImpactId(Integer impactId) {
        this.impactId = impactId;
    }


    /**
     * 
     * @return The relatedCiIds
     */
    @JsonProperty("relatedCiIds")
    public List<Object> getRelatedCiIds() {
        return relatedCiIds;
    }


    /**
     * 
     * @param relatedCiIds The relatedCiIds
     */
    @JsonProperty("relatedCiIds")
    public void setRelatedCiIds(List<Object> relatedCiIds) {
        this.relatedCiIds = relatedCiIds;
    }


    /**
     * 
     * @return The faqs
     */
    @JsonProperty("faqs")
    public List<Object> getFaqs() {
        return faqs;
    }


    /**
     * 
     * @param faqs The faqs
     */
    @JsonProperty("faqs")
    public void setFaqs(List<Object> faqs) {
        this.faqs = faqs;
    }


    /**
     * 
     * @return The attachments
     */
    @JsonProperty("attachments")
    public List<Object> getAttachments() {
        return attachments;
    }


    /**
     * 
     * @param attachments The attachments
     */
    @JsonProperty("attachments")
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }


    /**
     * 
     * @return The reachedBy
     */
    @JsonProperty("reachedBy")
    public String getReachedBy() {
        return reachedBy;
    }


    /**
     * 
     * @param reachedBy The reachedBy
     */
    @JsonProperty("reachedBy")
    public void setReachedBy(String reachedBy) {
        this.reachedBy = reachedBy;
    }


    /**
     * 
     * @return The ticketCategory
     */
    @JsonProperty("ticketCategory")
    public String getTicketCategory() {
        return ticketCategory;
    }


    /**
     * 
     * @param ticketCategory The ticketCategory
     */
    @JsonProperty("ticketCategory")
    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}