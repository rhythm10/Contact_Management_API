package com.springboot.assignment.controller;

import java.util.List;

import com.springboot.assignment.modal.Contacts;
import com.springboot.assignment.service.ContactsServiceImlp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {
	
	private final ContactsServiceImlp contactsService;
	
	public ContactsController(@Autowired ContactsServiceImlp contactsService) {
        this.contactsService = contactsService;
    }
	
	@PostMapping("/contacts")
	public void addContacts(@RequestBody Contacts contacts){
		contactsService.addContacts(contacts);
	}
	
	@GetMapping("/contacts")
	public List<Contacts> getAllContacts(){
		return contactsService.getAllContacts();
	}
	
	@GetMapping("/contacts/{id}")
	public Contacts getContactsById(@PathVariable Long id) {
        return contactsService.getContactsById(id);
    }
	
	@PutMapping("/{id}")
    public Contacts updateContact(@PathVariable Long id, @RequestBody Contacts contact) {
		Contacts existingContact = contactsService.getContactsById(id);
        if (existingContact == null) {
            return null;
        }
        return contactsService.updateContact(id, contact);
    }
    
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
    	Contacts existingContact = contactsService.getContactsById(id);
        if (existingContact != null) {
            contactsService.deleteContact(id);
        }
    }
    
    @GetMapping("/search/{query}")
    public List<Contacts> searchContacts(@PathVariable String query) {
        return contactsService.searchContacts(query);
    }
}
