package it.example.SpringRepo1.Repository;

import it.example.SpringRepo1.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {
}
