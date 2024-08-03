package hn.unah.lenguajes1900.creditos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.creditos.entities.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{

}
