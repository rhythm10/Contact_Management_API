package com.springboot.assignment.repository;

import java.util.List;

import com.springboot.assignment.modal.Contacts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends CrudRepository<Contacts, Long> {

	public List<Contacts> findByFirstName(String firstName);
    
    public List<Contacts> findByLastName(String lastName);
    
    public List<Contacts> findByEmail(String email);
    
}
