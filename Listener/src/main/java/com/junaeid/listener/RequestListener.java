package com.junaeid.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("Our request is destroyed");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("Our request Created");
    }
	
}
