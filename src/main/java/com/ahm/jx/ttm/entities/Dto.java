package com.ahm.jx.ttm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Dto<T> implements Serializable {

	private static final long serialVersionUID = 3564685821458581338L;
	
	private String status;
	
    private String message;
    
	private List<T> items;
    
    private List<String> messageItems;    
        
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getItems() {		
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public List<String> getMessageItems() {
		return messageItems;
	}

	public void setMessageItems(List<String> messageItems) {
		this.messageItems = messageItems;
	}
	
	public String addMessage(String s) {
		if (messageItems == null) messageItems = new ArrayList<String>();
		messageItems.add(s);
		return s;
	}
	
	public void addItem(T o) {
		if (items == null) items = new ArrayList<T>();
		items.add(o);
	}

    public ResponseEntity<List<T>> listAll() {
        if(items == null || items.size() == 0){
            return new ResponseEntity<List<T>>(HttpStatus.NOT_FOUND); 
        }
        return new ResponseEntity<List<T>>(items, HttpStatus.OK);
    }	
}
