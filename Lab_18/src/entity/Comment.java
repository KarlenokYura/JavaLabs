package entity;

import java.sql.Date;

public class Comment {
    int id;
    int refId;
    String sessionId;
    Date stamp;
    String comment;
    
    public Comment(int id,int refId,String sessionId,Date stamp,String comment) {
    	this.id = id;
    	this.refId = refId;
    	this.sessionId = sessionId;
    	this.stamp = stamp;
    	this.comment = comment;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }
    
    
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
