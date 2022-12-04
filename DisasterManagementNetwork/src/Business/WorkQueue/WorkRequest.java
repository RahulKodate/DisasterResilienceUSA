/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Arnab
 */
public class WorkRequest {
    private String workQueueId;
    private static int count = 1;
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private Long zipcode;
    
    public WorkRequest(){
       requestDate = new Date();
       workQueueId = "Work Request "+count++;
    }

    public String getWorkQueueId() {
        return workQueueId;
    }

    public void setWorkQueueId(String workQueueId) {
        this.workQueueId = workQueueId;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkRequest.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }
    
    @Override
    public String toString() {
        return workQueueId;
    }
}
