package br.com.springboot.sendemailmicroservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.sendemailmicroservice.model.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
    
}
