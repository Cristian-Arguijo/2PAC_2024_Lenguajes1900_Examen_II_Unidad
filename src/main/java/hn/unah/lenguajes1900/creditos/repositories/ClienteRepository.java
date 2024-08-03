package hn.unah.lenguajes1900.creditos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes1900.creditos.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,String>{

}
