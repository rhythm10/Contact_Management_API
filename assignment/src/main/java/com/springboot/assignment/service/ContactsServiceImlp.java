package com.springboot.assignment.service;

import java.util.ArrayList;
import java.util.List;

import com.springboot.assignment.modal.Contacts;
import com.springboot.assignment.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ContactsServiceImlp implements ContactsService {
	
	@Autowired
	private ContactsRepository contactsRepository;
	
    public ContactsServiceImlp(@Autowired ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
        addContacts(new Contacts(1l,"rhythm","sehgal","rhythmsehgal9@gmail.com","88128"));
        addContacts(new Contacts(2l,"rohit","sharma","rohit@gmail.com","43254"));
    }
    
    @Override
	public void addContacts(Contacts contacts) {
		contactsRepository.save(contacts);
	}

    @Override
	public List<Contacts> getAllContacts() {
		List<Contacts> list = new ArrayList<>();
		contactsRepository.findAll().forEach(list::add);
		return list;
	}

    @Override
	public Contacts getContactsById(Long id) {
		return contactsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contact not found with id " + id));
	}
	
    @Override
	public Contacts updateContact(Long id, Contacts contact) {
        Contacts existingContact = getContactsById(id);
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setPhonenumber(contact.getPhonenumber());
        return contactsRepository.save(existingContact);
    }
    
    @Override
    public void deleteContact(Long id) {
        Contacts contact = getContactsById(id);
        contactsRepository.delete(contact);
    }
    
    @Override
    public List<Contacts> searchContacts(String query) {
        List<Contacts> res = new ArrayList<>();
        res.addAll(contactsRepository.findByEmail(query));
        res.addAll(contactsRepository.findByFirstName(query));
        res.addAll(contactsRepository.findByLastName(query));
        return res;
    }

}
