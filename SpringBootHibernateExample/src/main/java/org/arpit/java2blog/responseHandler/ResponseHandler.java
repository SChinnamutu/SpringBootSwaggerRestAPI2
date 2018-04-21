package org.arpit.java2blog.responseHandler;

import org.arpit.java2blog.to.ResponseTo;

public class ResponseHandler {

	static ResponseTo responseTo = new ResponseTo();
	
	public static ResponseTo createResponse(String message) {
		responseTo.setStatus("Success");
		responseTo.setDesc(message);
		return responseTo;
	}
}
