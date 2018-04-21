package org.arpit.java2blog.to;

public class ResponseTo {

	public String status; 
	public String desc;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "ResponseTo [status=" + status + ", desc=" + desc + "]";
	} 
	
	
}
