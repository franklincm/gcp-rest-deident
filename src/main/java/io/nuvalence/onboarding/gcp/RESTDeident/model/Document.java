package io.nuvalence.onboarding.gcp.RESTDeident.model;

import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

public class Document {

    private String name;
    private String contentType;
    private long size;
    private long createTime;
    private String createTimeStr;
    
    public Document(String name, String contentType, long size, long createTime) {
	this.name = name;
	this.contentType = contentType;
	this.size = size;
	this.createTime = createTime;
	setCreateTimeStr();
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getContentType() {
	return this.contentType;
    }

    public void setContentType(String contentType) {
	this.contentType = contentType;
    }

    public long getSize() {
	return this.size;
    }

    public void setSize(long size) {
	this.size = size;
    }

    public long getCreateTime() {
	return this.createTime;
    }

    public void setCreateTime(long createTime) {
	this.createTime = createTime;
    }

    private void setCreateTimeStr() {
	if (this.createTimeStr == null || this.createTimeStr.isEmpty()) {
	    Date date = new Date(this.createTime);
	    Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
	    this.createTimeStr = format.format(date).toString();	    
	}
    }

    public String getCreateTimeStr() {
	if (this.createTimeStr == null || this.createTimeStr.isEmpty()) {
	    setCreateTimeStr();
	}
	
	return this.createTimeStr;
    }    

    @Override
    public String toString() {
	return "%s, %s, %d bytes, created: %s"
	    .format(
		    this.name,
		    this.contentType,
		    this.size,
		    this.createTimeStr
		    );
    }
}
