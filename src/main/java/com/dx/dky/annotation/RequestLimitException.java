package com.dx.dky.annotation;

public class RequestLimitException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public RequestLimitException() {  
        super("HTTP请求超出设定的限制");  
    }  
  
    public RequestLimitException(String message) {  
    	super(message);
        this.message = message;
    }  

    public void setMessage(String message) {
		this.message = message;
	}
    
    public String getMessage() {
		return message;
	}
}
