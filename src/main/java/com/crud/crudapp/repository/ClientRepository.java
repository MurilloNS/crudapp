package com.crud.crudapp.repository;

import com.crud.crudapp.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, String> {
    Client findById(Long id);
}
