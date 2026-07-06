package com.example.demo.repository.contact;

//import java.sql.Timestamp;
//import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.contact.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
