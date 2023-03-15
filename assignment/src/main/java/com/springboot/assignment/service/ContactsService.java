package com.springboot.assignment.service;

import com.springboot.assignment.modal.Contacts;

import java.util.List;


public interface ContactsService {
	
	public void addContacts(Contacts contacts);

	public List<Contacts> getAllContacts();

	public Contacts getContactsById(Long id);
	
	public Contacts updateContact(Long id, Contacts contact);
    
    public void deleteContact(Long id);
    
    public List<Contacts> searchContacts(String query);
    
}
